/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.dto;

/**
 *
 * @author senu2k
 */
public class ItemDTO {
    
    private String item_code;
    private String item_name;
    private String item_batch;
    private double item_price;
    private double shelf_qty;

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_batch() {
        return item_batch;
    }

    public void setItem_batch(String item_batch) {
        this.item_batch = item_batch;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public double getShelf_qty() {
        return shelf_qty;
    }

    public void setShelf_qty(double shelf_qty) {
        this.shelf_qty = shelf_qty;
    }
    
    
    
}
