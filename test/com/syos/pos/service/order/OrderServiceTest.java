/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.order;

import com.syos.pos.service.OrderService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 *
 * @author senu2k
 */
public class OrderServiceTest {
    
    private OrderService orderService;

    @Before
    public void setUp() {
        orderService = OrderService.getInstance();
    }

    @Test
    public void a_testCreateOrder() {
        String result = orderService.createOrder();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void b_testAddOrderProduct() throws Exception {
        String productCode = "P001";
        double quantity = 2;
        double result = orderService.addOrderProduct(productCode, quantity);
        assertEquals(100, result, 0);
        // Additional assertions can be added here to verify the behavior
    }

    @Test
    public void c_testAddDiscount() {
        double discountAmount = 10;
        double result = orderService.addDiscount(discountAmount);
        assertEquals(90, result, 0);
        // Additional assertions can be added here to verify the behavior
    }

    @Test
    public void d_testCheckoutPay() throws Exception {
        double amountTendered = 100;
        String paymentType = "Cash";
        double result = orderService.checkoutPay(amountTendered, paymentType);
        assertEquals(10, result, 0);
        // Additional assertions can be added here to verify the behavior
    }

    @Test
    public void e_testGetAvailableQty() throws Exception {
        String productCode = "P001";
        double result = orderService.getAvailableQty(productCode);
        assertEquals(3, result, 0);
        // Additional assertions can be added here to verify the behavior
    }

    @Test
    public void f_testUpdateShelf() throws Exception {
        String productCode = "P001";
        double quantity = 5;
        orderService.updateShelf(productCode, quantity);
        // Additional assertions can be added here to verify the behavior
    }

}
