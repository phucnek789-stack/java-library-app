/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.libraryapp;

import com.pnhp.strategy.BorrowType;
import com.pnhp.utils.MyStageSingleton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable {

    @FXML
    private ComboBox<BorrowType> cbBorrowTypes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Nạp các loại thẻ mượn vào ComboBox
        cbBorrowTypes.setItems(FXCollections.observableArrayList(BorrowType.values()));
        cbBorrowTypes.getSelectionModel().select(BorrowType.STANDARD);
    }

    @FXML
    private void switchToBookList(ActionEvent event) {
        // 1. Lấy loại thẻ được chọn từ ComboBox
        BorrowType selectedType = cbBorrowTypes.getValue();

        // 2. Chuyển sang màn hình danh sách sách bằng MyStageSingleton
        FXMLLoader loader = MyStageSingleton.getInstance().showStage("library");

        // 3. Truyền cấu hình BorrowType đã chọn sang LibraryController
        if (loader != null) {
            LibraryController libraryController = loader.getController();
            libraryController.setSelectedBorrowType(selectedType);
        }
    }
}