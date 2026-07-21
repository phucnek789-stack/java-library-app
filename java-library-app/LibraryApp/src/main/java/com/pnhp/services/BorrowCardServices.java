/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.services;

import com.pnhp.pojo.BorrowCard;
import com.pnhp.utils.MyConnSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrowCardServices {
    
    // Hàm thực hiện lưu phiếu mượn vào bảng borrow_card
    public boolean addBorrowCard(BorrowCard card) throws SQLException {
        String sql = "INSERT INTO borrow_card (member_name, borrow_date, total_fee) VALUES (?, NOW(), ?)";
        Connection conn = MyConnSingleton.getInstance().connect();
        
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, card.getMemberName());
            stm.setDouble(2, card.getTotalFee());
            return stm.executeUpdate() > 0;
        }
    }
}
