/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.entity;

import java.time.LocalDateTime;

/**
 *
 * @author senu2k
 */
public class BillHeader {
    
    private String bill_serial_number;
    private String customer_id;
    private String payment_type;
    private LocalDateTime date;
    private double total_bill_price;
    private double amount_tendered;
    private double discount;
    private double change;

    public String getBill_serial_number() {
        return bill_serial_number;
    }

    public void setBill_serial_number(String bill_serial_number) {
        this.bill_serial_number = bill_serial_number;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotal_bill_price() {
        return total_bill_price;
    }

    public void setTotal_bill_price(double total_bill_price) {
        this.total_bill_price = total_bill_price;
    }

    public double getAmount_tendered() {
        return amount_tendered;
    }

    public void setAmount_tendered(double amount_tendered) {
        this.amount_tendered = amount_tendered;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
    
    
    
}
