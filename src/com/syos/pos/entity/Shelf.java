/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.entity;

/**
 *
 * @author senu2k
 */
public class Shelf {
    
    private String item_code;
    private double capacity;
    private double item_qty;

    public Shelf(String item_code, double capacity, double item_qty) {
        this.item_code = item_code;
        this.capacity = capacity;
        this.item_qty = item_qty;
    }

    @Override
    public String toString() {
        return "Shelf{" + "Item code=" + item_code + ", Capacity=" + capacity + ", Item qty=" + item_qty + '}';
    }
    

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(double item_qty) {
        this.item_qty = item_qty;
    }
    
    
    
}
