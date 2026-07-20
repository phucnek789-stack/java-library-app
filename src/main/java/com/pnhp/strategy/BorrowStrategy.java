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

public abstract class BorrowStrategy {
    public abstract double calFee(List<Book> books, int days);
}
