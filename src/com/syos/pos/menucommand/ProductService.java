/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import com.syos.pos.controller.ProductController;
import com.syos.pos.dto.ProductDTO;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class ProductService {
    void add() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter product code: ");
        String product_code = scanner.nextLine();
        // Add code to get other input values for adding a product
        
        ProductController productController = new ProductController();
        ProductDTO productDTO = new ProductDTO();
        
        // Check if the product code already exists
        boolean productCodeExists = productController.checkProductCodeExists(product_code);
        
        try {

            if (productCodeExists) {
                System.out.println("Product code already exists!");
                return; // Exit the method if product code exists
            }else{
                // get the inputs for the product name and price
                System.out.println("Enter product name: ");
                String product_name = scanner.nextLine();
                System.out.println("Enter product price: ");
                double product_price = scanner.nextDouble();   
                
                productDTO.setProduct_code(product_code);
                productDTO.setProduct_name(product_name);
                productDTO.setProduct_price(product_price);
                
                productController.addItem(productDTO);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Product added !");
    }

    void update() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter product code to update: ");
        String product_code = scanner.nextLine();
        
        ProductController productController = new ProductController();
        ProductDTO productDTO = new ProductDTO();
        
        // Check if the product code exists
        boolean productCodeExists = productController.checkProductCodeExists(product_code);
        
        if (!productCodeExists) {
            System.out.println("Product code does not exist!");
            return; // Exit the method if product code does not exist
        }
        
        try {
            // Get the new values for product name and price
            System.out.println("Enter new product name: ");
            String product_name = scanner.nextLine();
            System.out.println("Enter new product price: ");
            double product_price = scanner.nextDouble();
            
            productDTO.setProduct_code(product_code);
            productDTO.setProduct_name(product_name);
            productDTO.setProduct_price(product_price);
            
            productController.updateItem(productDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Product updated !");
    }

    void delete() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product code: ");
            String product_code = scanner.nextLine();
            
            ProductController productController = new ProductController();
            if (productController.checkProductCodeExists(product_code)) {
                try {
                    productController.deleteItem(product_code);
                    System.out.println("Product deleted successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to delete product.");
                }
            } else {
                System.out.println("Product not found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(BatchService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAll() {
        ProductController productController = new ProductController();
        
        try {
            List<ProductDTO> products = productController.getAll();
            
            if (products.isEmpty()) {
                System.out.println("No products found!");
                return;
            }
            
            for (ProductDTO product : products) {
                System.out.println("Product code: " + product.getProduct_code());
                System.out.println("Product name: " + product.getProduct_name());
                System.out.println("Product price: " + product.getProduct_price());
                System.out.println("--------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
