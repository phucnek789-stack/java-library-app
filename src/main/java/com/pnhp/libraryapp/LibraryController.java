package com.pnhp.libraryapp;

import com.pnhp.pojo.Book;
import com.pnhp.pojo.BorrowCard;
import com.pnhp.services.BookServices;
import com.pnhp.services.BorrowCardServices;
import com.pnhp.strategy.BorrowStrategy;
import com.pnhp.strategy.BorrowType;
import com.pnhp.strategy.StandardBorrow;
import com.pnhp.strategy.StudentBorrow;
import com.pnhp.strategy.VipBorrow;
import com.pnhp.utils.AppConfigs;
import com.pnhp.utils.MyAlertSingleton;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LibraryController implements Initializable {

    @FXML private TableView<Book> tbBooks;
    @FXML private TableColumn<Book, Integer> colId;
    @FXML private TableColumn<Book, String> colTitle;
    @FXML private TableColumn<Book, String> colAuthor;
    @FXML private TableColumn<Book, Double> colPrice;

    @FXML private TextField txtMemberName;
    @FXML private TextField txtBorrowDays;

    private BorrowType selectedBorrowType = BorrowType.STANDARD;
    private final BookServices bookServices = new BookServices();
    private final BorrowCardServices borrowCardServices = new BorrowCardServices();

    // Nhận BorrowType được chuyển từ PrimaryController
    public void setSelectedBorrowType(BorrowType type) {
        if (type != null) {
            this.selectedBorrowType = type;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Map thuộc tính POJO Book vào cột TableView
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Cho phép chọn nhiều dòng sách
        tbBooks.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Nạp danh sách sách
        loadBookData();
    }

    private void loadBookData() {
        try {
            // Gọi hàm list() từ QueryServicebase chuẩn theo file của bạn
            List<Book> books = bookServices.list(); 
            tbBooks.setItems(FXCollections.observableList(books));
        } catch (SQLException ex) {
            MyAlertSingleton.getInstance().showMessage(
                "Không thể nạp danh sách sách: " + ex.getMessage(), 
                Alert.AlertType.ERROR
            );
        }
    }

    @FXML
    private void handleCreateBorrowCard(ActionEvent event) throws SQLException {
        String memberName = txtMemberName.getText();
        String daysStr = txtBorrowDays.getText();

        // 1. Kiểm tra tên thành viên
        if (memberName == null || memberName.trim().isEmpty()) {
            MyAlertSingleton.getInstance().showMessage(
                "Vui lòng nhập tên thành viên!", 
                Alert.AlertType.WARNING
            );
            return;
        }

        // 2. Kiểm tra số ngày mượn dựa trên AppConfigs chuẩn theo file của bạn
        int days;
        try {
            days = Integer.parseInt(daysStr);
            if (days <= 0 || days > AppConfigs.MAX_BORROW_DAY) {
                MyAlertSingleton.getInstance().showMessage(
                    "Số ngày mượn phải từ 1 đến " + AppConfigs.MAX_BORROW_DAY + " ngày!", 
                    Alert.AlertType.WARNING
                );
                return;
            }
        } catch (NumberFormatException e) {
            MyAlertSingleton.getInstance().showMessage(
                "Số ngày mượn phải là số nguyên hợp lệ!", 
                Alert.AlertType.WARNING
            );
            return;
        }

        // 3. Kiểm tra danh sách sách đã chọn
        ObservableList<Book> selectedBooks = tbBooks.getSelectionModel().getSelectedItems();
        if (selectedBooks.isEmpty()) {
            MyAlertSingleton.getInstance().showMessage(
                "Vui lòng chọn ít nhất 1 cuốn sách!", 
                Alert.AlertType.WARNING
            );
            return;
        }

        // 4. Khởi tạo Strategy tương ứng với BorrowType được chọn từ màn hình chính
        BorrowStrategy strategy;
        switch (this.selectedBorrowType) {
            case STUDENT:
                strategy = new StudentBorrow();
                break;
            case VIP:
                strategy = new VipBorrow();
                break;
            case STANDARD:
            default:
                strategy = new StandardBorrow();
                break;
        }

        // 5. Tính phí mượn bằng hàm calFee() chuẩn theo file BorrowStrategy của bạn
        double totalFee = strategy.calFee(selectedBooks, days);

        // 6. Lưu thẻ mượn vào DB
        BorrowCard card = new BorrowCard(memberName, totalFee);
        borrowCardServices.addBorrowCard(card);
        // 7. Hiển thị thông báo thành công bằng MyAlertSingleton
        String confirmMsg = String.format(
                "TẠO PHIẾU MƯỢN THÀNH CÔNG!\n\n" +
                        "• Thành viên: %s\n" +
                        "• Loai thẻ: %s\n" +
                        "• Số sách mượn: %d cuốn\n" +
                        "• Số ngày mượn: %d ngày\n" +
                        "-----------------------------------\n" +
                        "• TỔNG CHI PHÍ: %,.0f VNĐ",
                memberName, this.selectedBorrowType, selectedBooks.size(), days, totalFee
        );
        MyAlertSingleton.getInstance().showMessage(confirmMsg, Alert.AlertType.INFORMATION);
        // Reset form sau khi lưu thành công
        txtMemberName.clear();
        txtBorrowDays.clear();
        tbBooks.getSelectionModel().clearSelection();
    }
}