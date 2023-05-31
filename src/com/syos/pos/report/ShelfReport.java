/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.report;

import com.syos.pos.config.DBConnection;
import com.syos.pos.core.RepositoryCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author senu2k
 */
public class ShelfReport implements IReport {

    @Override
    public void generateReport() {
        try {
            String sql = "SELECT s.product_code, p.name AS product_name, " +
                        "s.available_qty AS total_qty, " +
                        "s.capacity AS shelf_capacity " +
                        "FROM shelf s " +
                        "JOIN product p ON s.product_code = p.product_code " +
                        "WHERE s.available_qty > 0";
            ResultSet resultSet = RepositoryCRUD.executeQuery(sql);

            System.out.println("Shelf Report:");
            System.out.println("==========================================");
            while (resultSet.next()) {
                String productCode = resultSet.getString("product_code");
                String productName = resultSet.getString("product_name");
                int totalQuantity = resultSet.getInt("total_qty");
                int shelfCapacity = resultSet.getInt("shelf_capacity");
                int reshelvedQuantity = shelfCapacity - totalQuantity;

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Total Quantity on Shelf: " + totalQuantity);
                System.out.println("Quantity to be Reshelved: " + reshelvedQuantity);
                System.out.println("------------------------------------------");
            }

            System.out.println("Items with Stock Below 50:");
            System.out.println("------------------------------------------");
            sql = "SELECT s.product_code, p.name AS product_name, s.available_qty " +
                    "FROM shelf s " +
                    "JOIN product p ON s.product_code = p.product_code " +
                    "WHERE s.available_qty < 50";
            resultSet = RepositoryCRUD.executeQuery(sql);
            while (resultSet.next()) {
                String productCode = resultSet.getString("product_code");
                String productName = resultSet.getString("product_name");
                int availableQty = resultSet.getInt("available_qty");

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);

        try {
            String sql = "SELECT s.product_code, p.name AS product_name, " +
                    "s.available_qty AS total_qty, " +
                    "s.capacity AS shelf_capacity " +
                    "FROM shelf s " +
                    "JOIN product p ON s.product_code = p.product_code " +
                    "WHERE s.available_qty > 0";
            ResultSet resultSet = RepositoryCRUD.executeQuery(sql);

            System.out.println("Shelf Report:");
            System.out.println("==========================================");
            while (resultSet.next()) {
                String productCode = resultSet.getString("product_code");
                String productName = resultSet.getString("product_name");
                int totalQuantity = resultSet.getInt("total_qty");
                int shelfCapacity = resultSet.getInt("shelf_capacity");
                int reshelvedQuantity = shelfCapacity - totalQuantity;

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Total Quantity on Shelf: " + totalQuantity);
                System.out.println("Quantity to be Reshelved: " + reshelvedQuantity);
                System.out.println("------------------------------------------");
            }

            System.out.println("Items with Stock Below 50:");
            System.out.println("------------------------------------------");
            sql = "SELECT s.product_code, p.name AS product_name, s.available_qty " +
                    "FROM shelf s " +
                    "JOIN product p ON s.product_code = p.product_code " +
                    "WHERE s.available_qty < 50";
            resultSet = RepositoryCRUD.executeQuery(sql);
            while (resultSet.next()) {
                String productCode = resultSet.getString("product_code");
                String productName = resultSet.getString("product_name");
                int availableQty = resultSet.getInt("available_qty");

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
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

    
    
}
