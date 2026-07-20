/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.strategy;

import com.pnhp.pojo.Book;
import java.util.List;

/**
 *
 * @author Phupham
 */
public class StandardBorrow extends BorrowStrategy {
    @Override
    public double calFee(List<Book> books, int days) {
        if (books == null || books.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (var b : books) {
            total += b.getPrice() * days;
        }
        return total;
    }
}
