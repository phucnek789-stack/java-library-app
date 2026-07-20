/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pnhp.pojo;

/**
 *
 * @author Phupham
 */
public class BorrowCard {
    private int id;
    private String memberName;
    private String borrowDate;
    private double totalFee;

    public BorrowCard() {
    }

    public BorrowCard(int id, String memberName, String borrowDate, double totalFee) {
        this.id = id;
        this.memberName = memberName;
        this.borrowDate = borrowDate;
        this.totalFee = totalFee;
    }

    // Thêm constructor này để gọi new BorrowCard(memberName, totalFee) không bị lỗi!
    public BorrowCard(String memberName, double totalFee) {
        this.memberName = memberName;
        this.totalFee = totalFee;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the borrowDate
     */
    public String getBorrowDate() {
        return borrowDate;
    }

    /**
     * @param borrowDate the borrowDate to set
     */
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * @return the totalFee
     */
    public double getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee the totalFee to set
     */
    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
}
