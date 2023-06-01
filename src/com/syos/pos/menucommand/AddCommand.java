/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import java.util.Scanner;

/**
 *
 * @author senu2k
 */
public class AddCommand implements Command {
     private final BatchService batchService;
    private final ProductService productService;
    private final ShelfService shelfService;
    private final OrderService orderService;
    String entity; // package-private access

    AddCommand(BatchService batchService, ProductService productService, ShelfService shelfService, OrderService orderService) {
        this.batchService = batchService;
        this.productService = productService;
        this.shelfService = shelfService;
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        switch (entity) {
            case "batch":
                batchService.add();
                break;
            case "product":
                productService.add();
                break;
            case "shelf":
                shelfService.add();
                break;
            case "order":
                orderService.add();
                break;
            default:
                System.out.println("Invalid entity!");
                break;
        }
    }
    
}
