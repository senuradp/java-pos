/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.report;

import com.syos.pos.core.RepositoryCRUD;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author senu2k
 */
public class BillReport implements IReport {

    @Override
    public void generateReport() {
        try {
            String sql = "SELECT bh.bill_serial_number, bh.payment_type, bh.date, " +
                    "bh.total_bill_price, bh.amount_tendered, bh.discount, bh.balance, " +
                    "bd.product_code, bd.product_name, bd.product_qty, bd.product_price, bd.total_item_price " +
                    "FROM bill_header bh " +
                    "JOIN bill_detail bd ON bh.bill_serial_number = bd.bill_serial_number";
            ResultSet resultSet = RepositoryCRUD.executeQuery(sql);

            System.out.println("==========================================");
            System.out.println("============== Bill Report ===============");
            System.out.println("==========================================");
            String currentBillSerialNumber = "";
            while (resultSet.next()) {
                String billSerialNumber = resultSet.getString("bill_serial_number");
                String paymentType = resultSet.getString("payment_type");
                String date = resultSet.getString("date");
                double totalBillPrice = resultSet.getDouble("total_bill_price");
                double amountTendered = resultSet.getDouble("amount_tendered");
                double discount = resultSet.getDouble("discount");
                double balance = resultSet.getDouble("balance");
                String productCode = resultSet.getString("product_code");
                String productName = resultSet.getString("product_name");
                int productQty = resultSet.getInt("product_qty");
                double productPrice = resultSet.getDouble("product_price");
                double totalItemPrice = resultSet.getDouble("total_item_price");

                if (!billSerialNumber.equals(currentBillSerialNumber)) {
                    System.out.println("==========================================");
                    System.out.println("Bill Serial Number: " + billSerialNumber);
                    System.out.println("==========================================");
                    System.out.println("Payment Type: " + paymentType);
                    System.out.println("Date: " + date);
                    System.out.println("Total Bill Price: " + totalBillPrice);
                    System.out.println("Amount Tendered: " + amountTendered);
                    System.out.println("Discount: " + discount);
                    System.out.println("Balance: " + balance);
                    System.out.println("------------------------------------------");
                    currentBillSerialNumber = billSerialNumber;
                }

                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Quantity: " + productQty);
                System.out.println("Price per Item: " + productPrice);
                System.out.println("Total Item Price: " + totalItemPrice);
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
