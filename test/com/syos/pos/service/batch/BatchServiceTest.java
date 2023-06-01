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
public class BatchServiceTest {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Test
    public void a_testAdd() {
        try {
            // Create a BatchDTO object with sample data for testing
            BatchDTO batchDTO = new BatchDTO();
            batchDTO.setBatch_code("B006");
            batchDTO.setPurchase_date(dateFormat.parse("2023-05-25"));
            batchDTO.setExpiry_date(dateFormat.parse("2023-06-25"));
            batchDTO.setProduct_code("P001");
            batchDTO.setBatch_qty(100);
            batchDTO.setAvailable_qty(100);
            batchDTO.setIs_sold(false);

            BatchService batchService = new BatchService();
            boolean result = batchService.add(batchDTO);
            assertTrue(result);
        } catch (ParseException ex) {
            Logger.getLogger(BatchServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Test
    public void b_testUpdate() {
        try {
            // Create a BatchDTO object with sample data for testing
            BatchDTO batchDTO = new BatchDTO();
            batchDTO.setBatch_code("B006");
            batchDTO.setPurchase_date(dateFormat.parse("2023-05-26"));
            batchDTO.setExpiry_date(dateFormat.parse("2023-05-27"));
            batchDTO.setProduct_code("P002");
            batchDTO.setBatch_qty(100);
            batchDTO.setAvailable_qty(100);
            batchDTO.setIs_sold(false);

            BatchService batchService = new BatchService();
            boolean result = batchService.update(batchDTO);
            assertTrue(result);
        } catch (ParseException ex) {
            // Handle the ParseException within the method
            fail("ParseException occurred: " + ex.getMessage());
        }
    }


    @Test
    public void c_testDelete() throws Exception {
        String code = "B006";

        BatchService batchService = new BatchService();
        boolean result = batchService.delete(code);
        assertTrue(result);
    }

    @Test
    public void d_testCheckBatchCodeExists() throws Exception {
        String batch_code = "B001";

        BatchService batchService = new BatchService();
        boolean result = batchService.checkBatchCodeExists(batch_code);
        assertTrue(result);
    }

    @Test
    public void e_testGetBatchDetails() throws Exception {
        String batch_code = "B001";

        BatchService batchService = new BatchService();
        BatchDTO batchDTO = batchService.getBatchDetails(batch_code);
        assertNotNull(batchDTO);
        assertEquals(batch_code, batchDTO.getBatch_code());
    }

    @Test
    public void f_testGetExpiringBatchDetails() {
        String product_code = "P001";

        BatchService batchService = new BatchService();
        List<BatchDTO> expiringBatchDTOs = batchService.getExpiringBatchDetails(product_code);
        assertNotNull(expiringBatchDTOs);
        assertFalse(expiringBatchDTOs.isEmpty());
    }
    
    @Test
    public void g_testGetAll() throws Exception {
        BatchService batchService = new BatchService();
        List<BatchDTO> allBatchDTOs = batchService.getAll();
        assertNotNull(allBatchDTOs);
        assertFalse(allBatchDTOs.isEmpty());
    }
    
}
