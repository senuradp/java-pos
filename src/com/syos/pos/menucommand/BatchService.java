/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.syos.pos.controller.BatchController;
import com.syos.pos.dto.BatchDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class BatchService {

    

    void add() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
//
        System.out.println("Enter batch code: ");
        String batch_code = scanner.nextLine();
         BatchController batchController = new BatchController();
        try {
            if (!batchController.checkBatchCodeExists(batch_code)) {

                System.out.println("Enter product code: ");
                String product_code = scanner.nextLine();
                System.out.println("Enter expiry date (yyyy-MM-dd): ");
                String expiry_date = scanner.nextLine();
                System.out.println("Enter purchase date (yyyy-MM-dd): ");
                String purchase_date = scanner.nextLine();
                System.out.println("Enter batch quantity: ");
                double batch_qty = scanner.nextDouble();
                System.out.println("Enter available quantity: ");
                double available_qty = scanner.nextDouble();
                System.out.println("Enter is sold (true/false): ");
                boolean is_sold = scanner.nextBoolean();

                BatchDTO batchDTO = new BatchDTO();

                // try catch to add batch
                try {
                    batchDTO.setBatch_code(batch_code);
                    batchDTO.setProduct_code(product_code);
                    batchDTO.setBatch_qty(batch_qty);
                    batchDTO.setExpiry_date(dateFormat.parse(expiry_date));
                    batchDTO.setPurchase_date(dateFormat.parse(purchase_date));
                    batchDTO.setAvailable_qty(available_qty);
                    batchDTO.setIs_sold(is_sold);
                    batchController.addBatch(batchDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Batch added !");
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

//    void update() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Scanner scanner = new Scanner(System.in);
//    
//        System.out.println("Enter batch code: ");
//        String batch_code = scanner.nextLine();
//    
//        BatchController batchController = new BatchController();
//        try {
//            if (batchController.checkBatchCodeExists(batch_code)) {
//                System.out.println("Batch found. Enter '1' to update purchase date, '2' to update expiry date, or '0' to cancel: ");
//                int option = scanner.nextInt();
//                scanner.nextLine(); // Consume newline character
//   
//                switch (option) {
//                    case 1:
//                        System.out.println("Enter new purchase date (yyyy-MM-dd): ");
//                        String purchase_date = scanner.nextLine();
//                        try {
//                            BatchDTO batchDTO = new BatchDTO();
//                            batchDTO.setBatch_code(batch_code);
//                            batchDTO.setPurchase_date(dateFormat.parse(purchase_date));
//                            batchController.updateBatch(batchDTO);
//                            System.out.println("Purchase date updated successfully!");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            System.out.println("Failed to update purchase date.");
//                        }
//                        break;
//   
//                    case 2:
//                        System.out.println("Enter new expiry date (yyyy-MM-dd): ");
//                        String expiry_date = scanner.nextLine();
//                        try {
//   
//                            BatchDTO batchDTO = new BatchDTO();
//                            batchDTO.setBatch_code(batch_code);
//                            batchDTO.setExpiry_date(dateFormat.parse(expiry_date));
//                            batchController.updateBatch(batchDTO);
//                            System.out.println("Expiry date updated successfully!");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            System.out.println("Failed to update expiry date.");
//                        }
//                        break;
//   
//                    case 0:
//                        System.out.println("Update cancelled.");
//                        break;
//   
//                    default:
//                        System.out.println("Invalid option. Update canceled.");
//                        break;
//                }
//            } else {
//                System.out.println("Batch not found.");
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
     
    void update() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter batch code: ");
        String batch_code = scanner.nextLine();

        BatchController batchController = new BatchController();
        try {
            if (batchController.checkBatchCodeExists(batch_code)) {
                System.out.println("Batch found. Enter '1' to update purchase date, '2' to update expiry date, or '0' to cancel: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                BatchDTO batchDTO = new BatchDTO();
                batchDTO.setBatch_code(batch_code);
                BatchDTO existingBatch = batchController.getBatchDetails(batch_code);
                
                batchDTO.setProduct_code(existingBatch.getProduct_code()); // Retain existing product
                batchDTO.setBatch_qty(existingBatch.getBatch_qty()); // Retain existing batch qty
                batchDTO.setAvailable_qty(existingBatch.getAvailable_qty()); // Retain existing available qty

                switch (option) {
                    case 1:
                        try {
                            batchDTO.setExpiry_date(existingBatch.getExpiry_date()); // Retain existing expiry date
                            System.out.println("Enter new purchase date (yyyy-MM-dd): ");
                            String purchase_date = scanner.nextLine();
                            try {
                                batchDTO.setPurchase_date(dateFormat.parse(purchase_date));
                                batchController.updateBatch(batchDTO);
                                System.out.println("Purchase date updated successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Failed to update purchase date.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Failed to retrieve existing batch details.");
                        }
                        break;

                    // Update expiry date
                    case 2:
                        try {
                            batchDTO.setPurchase_date(existingBatch.getPurchase_date()); // Retain existing purchase date
                            System.out.println("Enter new expiry date (yyyy-MM-dd): ");
                            String expiry_date = scanner.nextLine();
                            try {
                                batchDTO.setExpiry_date(dateFormat.parse(expiry_date));
                                batchController.updateBatch(batchDTO);
                                System.out.println("Expiry date updated successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Failed to update expiry date.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Failed to retrieve existing batch details.");
                        }
                        break;

                    case 0:
                        System.out.println("Update cancelled.");
                        break;

                    default:
                        System.out.println("Invalid option. Update cancelled.");
                        break;
                }
            } else {
                System.out.println("Batch not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void delete() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter batch code: ");
            String batch_code = scanner.nextLine();
            
            BatchController batchController = new BatchController();
            if (batchController.checkBatchCodeExists(batch_code)) {
                try {
                    batchController.deleteBatch(batch_code);
                    System.out.println("Batch deleted successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to delete batch.");
                }
            } else {
                System.out.println("Batch not found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(BatchService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAll() {
        try {
            BatchController batchController = new BatchController();
            List<BatchDTO> batches = batchController.getAll();
            
            if (!batches.isEmpty()) {
                System.out.println("All Batches:");
                for (BatchDTO batch : batches) {
                    System.out.println("Batch Code: " + batch.getBatch_code());
                    System.out.println("Product Code: " + batch.getProduct_code());
                    System.out.println("Expiry Date: " + batch.getExpiry_date());
                    System.out.println("Purchase Date: " + batch.getPurchase_date());
                    System.out.println("Batch Quantity: " + batch.getBatch_qty());
                    System.out.println("Available Quantity: " + batch.getAvailable_qty());
                    System.out.println("Is Sold: " + batch.getIs_sold());
                    System.out.println("-----------------------");
                }
            } else {
                System.out.println("No batches found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(BatchService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
