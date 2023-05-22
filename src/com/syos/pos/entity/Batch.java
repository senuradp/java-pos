/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.entity;

import java.time.LocalDate;

/**
 *
 * @author senu2k
 */
public class Batch {
    
    private String batch_code;
    private LocalDate expiry_date;
    private LocalDate purchase_date;
    private String item_code;
    private double batch_qty;
    private double available_qty;
    private boolean shelf_status; // in store | in shelf

    public Batch(String batch_code, LocalDate expiry_date, LocalDate purchase_date, String item_code, double batch_qty, double available_qty, boolean shelf_status) {
        this.batch_code = batch_code;
        this.expiry_date = expiry_date;
        this.purchase_date = purchase_date;
        this.item_code = item_code;
        this.batch_qty = batch_qty;
        this.available_qty = available_qty;
        this.shelf_status = shelf_status;
    }

    @Override
    public String toString() {
        return "Batch{" + "Batch code=" + batch_code + ", Expiry date=" + expiry_date + ", Purchase date=" + purchase_date + ", Item code=" + item_code + ", Batch qty=" + batch_qty + ", Available qty=" + available_qty + ", Shelf status=" + shelf_status + '}';
    }
    
    
    
    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public double getBatch_qty() {
        return batch_qty;
    }

    public void setBatch_qty(double batch_qty) {
        this.batch_qty = batch_qty;
    }

    public double getAvailable_qty() {
        return available_qty;
    }

    public void setAvailable_qty(double available_qty) {
        this.available_qty = available_qty;
    }

    public boolean isShelf_status() {
        return shelf_status;
    }

    public void setShelf_status(boolean shelf_status) {
        this.shelf_status = shelf_status;
    }
    
    
    
}
