/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phupham
 */
public abstract class QueryServicebase<T> {
    public List<T> list() throws SQLException{
        PreparedStatement stm = this.getStm();
        ResultSet rs = stm.executeQuery();

        List<T> results = new ArrayList<>();
        while(rs.next()){
            results.add(this.getObject(rs));
        }
        return results;
    }
    
    public abstract PreparedStatement getStm() throws SQLException;
    public abstract T getObject(ResultSet rs) throws SQLException;
}
