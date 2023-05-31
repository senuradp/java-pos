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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author senu2k
 */
public class SalesReport implements IReport {
    
    private RepositoryCRUD connection;

    @Override
    public void generateReport() {
        
    }


    @Override
    public void generateReportByDate(Date date) {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);

        String sql = "SELECT bd.product_code, p.name AS product_name, bd.product_qty, bd.total_item_price " +
                "FROM bill_detail bd " +
                "JOIN product p ON bd.product_code = p.product_code " +
                "JOIN bill_header bh ON bd.bill_serial_number = bh.bill_serial_number " +
                "WHERE bh.date = ?";

        try (Connection connection = DBConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, formattedDate);
            ResultSet resultSet = statement.executeQuery();

            double totalRevenue = 0;
            int totalQuantity = 0;

            System.out.println("Sales Report for " + formattedDate + ":");
            System.out.println("==========================================");
            while (resultSet.next()) {
                String productCode = resultSet.getString("product_code");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("product_qty");
                double itemPrice = resultSet.getDouble("total_item_price");

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Quantity: " + quantity);
                System.out.println("Item Price: " + itemPrice);

                totalRevenue += itemPrice;
                totalQuantity += quantity;

                System.out.println("------------------------------------------");
            }

            System.out.println("Total Quantity: " + totalQuantity + " items");
            System.out.println("Total Revenue: LKR " + totalRevenue);
            System.out.println("==========================================");

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        
    }

   
    
}
