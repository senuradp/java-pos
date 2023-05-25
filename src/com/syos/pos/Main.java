/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos;

import com.syos.pos.controller.ProductController;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.syos.pos.controller.ShelfController;
import com.syos.pos.dto.BatchDTO;
import com.syos.pos.dto.ProductDTO;
import com.syos.pos.dto.ShelfDTO;
import com.syos.pos.service.OrderService;

/**
 *
 * @author senu2k
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        // using order service, create an order and add orders

        OrderService orderService = OrderService.getInstance();
        orderService.createOrder();
        orderService.addOrderProduct("P001", 1);
        orderService.addOrderProduct("P002", 2);
        
        orderService.addDiscount(10);

        orderService.checkoutPay(300, "Cash");


    }
    
}
