/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos;

import com.syos.pos.controller.BatchController;
import com.syos.pos.controller.ProductController;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.syos.pos.controller.ShelfController;
import com.syos.pos.dto.BatchDTO;
import com.syos.pos.dto.ProductDTO;
import com.syos.pos.dto.ShelfDTO;
import com.syos.pos.entity.Batch;
import com.syos.pos.menucommand.Menu;
import com.syos.pos.report.FacadeReport;
import com.syos.pos.service.BatchService;
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

        orderService.addDiscount(10);
        orderService.checkoutPay(100, "Cash");

        // update the quantity of the batch where product code is P002
//        BatchController batchController = new BatchController();
//        batchController.updateBatchQty("P002", 30);

        // restock shelf
//         ShelfController shelfController = new ShelfController();
//         shelfController.reStockShelf("P002", 5);


//        BatchController batchController = new BatchController();
//        // get into array list and loop and print
//        batchController.getExpiringBatchDetails("P001");

//        FacadeReport report = new FacadeReport();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
//        report.getSalesReport().generateReportByDate(dateFormat.parse("2023-05-25"));
//        report.getShelfReport().generateReport();
//        report.getShelfReport().generateReportByDate(dateFormat.parse("2023-05-31"));
//        report.getStockReport().generateReport();
//        report.getBillReport().generateReport();

 
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // // add a batch
        // BatchController batchController = new BatchController();
        // BatchDTO batchDTO = new BatchDTO();
        // batchDTO.setBatch_code("B001");
        // batchDTO.setProduct_code("P001");
        // batchDTO.setBatch_qty(40);
        // batchDTO.setExpiry_date(dateFormat.parse("2023-06-01"));
        // batchDTO.setPurchase_date(dateFormat.parse("2023-05-25"));
        // batchDTO.setAvailable_qty(40);
        // batchDTO.setIs_sold(true);

        // batchController.addBatch(batchDTO);
         
        //        Menu menu = new Menu();
        //        menu.display();
        
    
         // get input from user

//         Scanner scanner = new Scanner(System.in);
//
//         System.out.println("Enter batch code: ");
//         String batch_code = scanner.nextLine();
//         System.out.println("Enter product code: ");
//         String product_code = scanner.nextLine();
//         System.out.println("Enter batch quantity: ");
//         double batch_qty = scanner.nextDouble();
//         System.out.println("Enter expiry date (yyyy-MM-dd): ");
//         scanner.nextLine();
//         String expiry_date = scanner.nextLine();
//         System.out.println("Enter purchase date (yyyy-MM-dd): ");
//         scanner.nextLine();
//         String purchase_date = scanner.nextLine();
//         System.out.println("Enter available quantity: ");
//         double available_qty = scanner.nextDouble();
//         System.out.println("Enter is sold (true/false): ");
//         boolean is_sold = scanner.nextBoolean();
//         
// 
//         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         BatchController batchController = new BatchController();
//         BatchDTO batchDTO = new BatchDTO();
//         
//         // try catch to add batch
//         try {
//             batchDTO.setBatch_code(batch_code);
//             batchDTO.setProduct_code(product_code);
//             batchDTO.setBatch_qty(batch_qty);
//             batchDTO.setExpiry_date(dateFormat.parse(expiry_date));
//             batchDTO.setPurchase_date(dateFormat.parse(purchase_date));
//             batchDTO.setAvailable_qty(available_qty);
//             batchDTO.setIs_sold(is_sold);
//             batchController.addBatch(batchDTO);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
// 
//         System.out.println("Batch added !");
           

    }
    
}
