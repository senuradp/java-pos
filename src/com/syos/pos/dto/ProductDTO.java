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
public class ProductDTO {
    
    private String product_code;
    private String product_name;
    private String product_batch;
    private double product_price;
    private double shelf_qty;

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_batch() {
        return product_batch;
    }

    public void setProduct_batch(String product_batch) {
        this.product_batch = product_batch;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public double getShelf_qty() {
        return shelf_qty;
    }

    public void setShelf_qty(double shelf_qty) {
        this.shelf_qty = shelf_qty;
    }
    
    
    
}
