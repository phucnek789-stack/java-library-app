/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.services;

import com.pnhp.pojo.Book;
import com.pnhp.pojo.Category;
import com.pnhp.utils.MyConnSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Phupham
 */
public class BookServices extends QueryServicebase<Book>{

    @Override
    public PreparedStatement getStm() throws SQLException {
        return MyConnSingleton.getInstance().connect().prepareCall(" SELECT * FROM book");
    }

    @Override
    public Book getObject(ResultSet rs) throws SQLException {
        int catId = rs.getInt("category_id");
        Category cat = new Category();
        return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"), cat);
    }
}
