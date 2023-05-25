/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service;

import com.syos.pos.core.ServiceFactory;
import com.syos.pos.dto.BillDetailDTO;
import com.syos.pos.dto.BillHeaderDTO;
import com.syos.pos.service.dao.IProductService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author senu2k
 */
public class OrderService {
    
    private static OrderService orderServiceInstance;
    private BillHeaderDTO billHeaderDTO;
    
    private static final IProductService productService = (IProductService)ServiceFactory.getInstance().getDAO(ServiceFactory.ServiceType.PRODUCT);

    private OrderService() {
    }
    
    public static OrderService getInstance(){
        if(orderServiceInstance == null){
            orderServiceInstance = new OrderService();
        }
        return orderServiceInstance;
    }
    
    public String createOrder(){
        
        LocalDateTime currentDateTime = LocalDateTime.now();
//        prefix not needed since already defined above
        billHeaderDTO = new BillHeaderDTO();
        billHeaderDTO.setBill_serial_number(generateSerialNumber());
//        billHeaderDTO.setDate();
        
        return billHeaderDTO.getBill_serial_number();
    }
    
    public double addOrderProduct(String product_code, double qty){
        double total_price = 0;
        
//        productService.get // product by code (this gives the name and price and thers and pass to th blow function)
        billHeaderDTO.addProduct(product_code, "test", qty, qty);
        
        return billHeaderDTO.getTotal_bill_price();
    }
    
    public double addDiscount(double discount_amount){
        double total_price = 0;
        
        billHeaderDTO.setDiscount(discount_amount);
        
        return billHeaderDTO.getTotal_bill_price();
    }
    
    public double checkoutPay(double amount_tendered){
        double balance = 0;
        
        balance = calculateBalancePay(amount_tendered);
        
//        update stock
        

//        save bill header and detail
        
        return balance;
    }
    
    public void updateShelf(String product_code, double qty) throws Exception{
        

    }
    
    public String generateSerialNumber(){
        
        String prefix = "B00";
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        String serial_number = prefix + timestamp;

        return serial_number;
    }
    
    public double calculateTotalPrice(double price, double qty){
        double total_price = 0;
        
        return 0;
    }
    
    public double calculateBalancePay(double amount_tendered){
        double balance = 0;
        
        return balance;
    }
    
}
