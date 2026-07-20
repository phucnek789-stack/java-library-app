/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.services;

import com.pnhp.pojo.Category;
import com.pnhp.utils.MyConnSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Phupham
 */
public class CategoryServices extends QueryServicebase<Category>{

    @Override
    public PreparedStatement getStm() throws SQLException {
        return MyConnSingleton.getInstance().connect().prepareCall(" SELECT * FROM category");
    }

    @Override
    public Category getObject(ResultSet rs) throws SQLException {
        return new Category(rs.getInt("id"), rs.getString("name")) ;
    }   
}
