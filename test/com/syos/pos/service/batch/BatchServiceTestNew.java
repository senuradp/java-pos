/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.batch;

import com.syos.pos.dto.BatchDTO;
import com.syos.pos.service.BatchService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class BatchServiceTestNew {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private static BatchService batchService;
    private BatchDTO testBatchDTO;

    @BeforeClass
    public static void setUpClass() {
        // Perform any setup steps that are common to all test cases in the class
        batchService = new BatchService();
    }

    @AfterClass
    public static void tearDownClass() {
        // Perform any cleanup tasks that are common to all test cases in the class
        batchService = null;
    }

    @Before
    public void setUp() {
        // Perform any setup steps that are required before each individual test case
        testBatchDTO = new BatchDTO();
        testBatchDTO.setBatch_code("B006");
        try {
            testBatchDTO.setPurchase_date(dateFormat.parse("2023-05-25"));
            testBatchDTO.setExpiry_date(dateFormat.parse("2023-06-25"));
        } catch (ParseException ex) {
            Logger.getLogger(BatchServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        testBatchDTO.setProduct_code("P001");
        testBatchDTO.setBatch_qty(100);
        testBatchDTO.setAvailable_qty(100);
        testBatchDTO.setIs_sold(false);
    }

    @After
    public void tearDown() {
        // Perform any cleanup tasks that are required after each individual test case
        testBatchDTO = null;
    }

    @Test
    public void a_testAdd() {
        boolean result = batchService.add(testBatchDTO);
        assertTrue(result);
    }

    @Test
    public void b_testUpdate() {
        testBatchDTO.setProduct_code("P002");
        boolean result = batchService.update(testBatchDTO);
        assertTrue(result);
    }

    @Test
    public void c_testDelete() throws Exception {
        String code = testBatchDTO.getBatch_code();
        boolean result = batchService.delete(code);
        assertTrue(result);
    }

    @Test
    public void d_testCheckBatchCodeExists() throws Exception {
        String batch_code = "B001";
        boolean result = batchService.checkBatchCodeExists(batch_code);
        assertTrue(result);
    }

    @Test
    public void e_testGetBatchDetails() throws Exception {
        String batch_code = "B001";
        BatchDTO batchDTO = batchService.getBatchDetails(batch_code);
        assertNotNull(batchDTO);
        assertEquals(batch_code, batchDTO.getBatch_code());
    }

    @Test
    public void f_testGetExpiringBatchDetails() {
        String product_code = "P001";
        List<BatchDTO> expiringBatchDTOs = batchService.getExpiringBatchDetails(product_code);
        assertNotNull(expiringBatchDTOs);
        assertFalse(expiringBatchDTOs.isEmpty());
    }

    @Test
    public void g_testGetAll() throws Exception {
        List<BatchDTO> allBatchDTOs = batchService.getAll();
        assertNotNull(allBatchDTOs);
        assertFalse(allBatchDTOs.isEmpty());
    }
}
