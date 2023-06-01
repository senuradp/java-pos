/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.product;

import com.syos.pos.dto.ProductDTO;
import com.syos.pos.service.ProductService;
import java.util.List;
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
public class ProductServiceTest {
    
    private static ProductService productService;
    private ProductDTO testProductDTO;
    
    @BeforeClass
    public static void setUpClass() {
        productService = new ProductService();
    }
    
    @AfterClass
    public static void tearDownClass() {
        productService = null;
    }
    
    @Before
    public void setUp() {
        testProductDTO = new ProductDTO();
        testProductDTO.setProduct_code("P008");
        testProductDTO.setProduct_name("Sample Product");
        testProductDTO.setProduct_price(40);
    }
    
    @After
    public void tearDown() {
        testProductDTO = null;
    }

    @Test
    public void a_testAdd() {
        boolean result = productService.add(testProductDTO);
        assertTrue(result);
    }

    @Test
    public void b_testUpdate() {
        testProductDTO.setProduct_name("New name");
        boolean result = productService.update(testProductDTO);
        assertTrue(result);
    }

    @Test
    public void c_testDelete() throws Exception {
        String code = testProductDTO.getProduct_code();
        boolean result = productService.delete(code);
        assertTrue(result);
    }

    @Test
    public void d_testGetAll() throws Exception {
        List<ProductDTO> allProductDTOs = productService.getAll();
        assertNotNull(allProductDTOs);
        assertFalse(allProductDTOs.isEmpty());
    }

    @Test
    public void e_testGetProductByCode() throws Exception {
        String code = "P001";
        ProductDTO productDTO = productService.getProductByCode(code);
        assertNotNull(productDTO);
    }
    
}
