/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.report;

import com.syos.pos.core.RepositoryCRUD;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author senu2k
 */
public class StockReport implements IReport {

    @Override
    public void generateReport() {
        
         try {
            String sql = "SELECT b.batch_code, b.purchase_date, b.expiry_date, " +
                    "b.batch_qty, b.available_qty, p.name AS product_name " +
                    "FROM batch b " +
                    "JOIN product p ON b.product_code = p.product_code";
            ResultSet resultSet = RepositoryCRUD.executeQuery(sql);

            System.out.println("Stock Report:");
            System.out.println("==========================================");
            while (resultSet.next()) {
                String batchCode = resultSet.getString("batch_code");
                String purchaseDate = resultSet.getString("purchase_date");
                String expiryDate = resultSet.getString("expiry_date");
                int batchQty = resultSet.getInt("batch_qty");
                int availableQty = resultSet.getInt("available_qty");
                String productName = resultSet.getString("product_name");

                System.out.println("Batch Code: " + batchCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Purchase Date: " + purchaseDate);
                System.out.println("Expiry Date: " + expiryDate);
                System.out.println("Quantity Received: " + batchQty);
                System.out.println("Available Quantity: " + availableQty);
                System.out.println("------------------------------------------");
            }

            System.out.println("==========================================");

            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        
    }

    @Override
    public void generateReportByDate(Date date) {
        
    }

    
    
}
