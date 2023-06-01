/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.controller;


import com.syos.pos.dto.ProductDTO;
import com.syos.pos.repository.BatchRepository;
import com.syos.pos.service.BatchService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author senu2k
 */



public class BatchTest {
    @Mock
    private BatchRepository batchRepository;

    @InjectMocks
    private BatchService batchService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProductToBatch() {
        ProductDTO productDTO = new ProductDTO("P001", "Sample Product", 10.99);
        BatchDAO batchDAO = new BatchDAO();
        batchService.addProductToBatch(batchDAO, productDTO);

        verify(batchRepository, times(1)).save(batchDAO);
        assertTrue(batchDAO.hasProduct(productDTO));
    }

    @Test
    public void testRemoveProductFromBatch() {
        ProductDTO productDTO = new ProductDTO("P002", "Another Product", 19.99);
        BatchDAO batchDAO = new BatchDAO();
        batchDAO.addProduct(productDTO);

        batchService.removeProductFromBatch(batchDAO, productDTO);

        verify(batchRepository, times(1)).save(batchDAO);
        assertFalse(batchDAO.hasProduct(productDTO));
    }

    @Test
    public void testGetTotalPrice() {
        ProductDTO productDTO1 = new ProductDTO("P001", "Product 1", 10.99);
        ProductDTO productDTO2 = new ProductDTO("P002", "Product 2", 5.99);

        BatchDAO batchDAO = new BatchDAO();
        batchDAO.addProduct(productDTO1);
        batchDAO.addProduct(productDTO2);

        double expectedTotalPrice = 16.98;
        double actualTotalPrice = batchService.getTotalPrice(batchDAO);

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    @Test
    public void testGetProductCount() {
        ProductDTO productDTO1 = new ProductDTO("P001", "Product 1", 10.99);
        ProductDTO productDTO2 = new ProductDTO("P002", "Product 2", 5.99);

        BatchDAO batchDAO = new BatchDAO();
        batchDAO.addProduct(productDTO1);
        batchDAO.addProduct(productDTO2);

        int expectedProductCount = 2;
        int actualProductCount = batchService.getProductCount(batchDAO);

        assertEquals(expectedProductCount, actualProductCount);
    }
}
