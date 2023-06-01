/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.batch;

import com.syos.pos.dto.BatchDTO;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import com.syos.pos.service.BatchService;
import com.syos.pos.repository.BatchRepository;
import com.syos.pos.entity.Batch;
import com.syos.pos.service.BatchService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * @author senu2k
 */
public class BatchServiceTestMock {
    private BatchService batchService;
    private BatchRepository batchRepositoryMock;
    private SimpleDateFormat dateFormat;

    @Before
    public void setUp() {
        batchService = new BatchService();
        batchRepositoryMock = mock(BatchRepository.class);
        setPrivateField(batchService, "batchRepositoryDAO", batchRepositoryMock);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Test
    public void testAdd() throws ParseException {
        // Create a BatchDTO object with sample data for testing
        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setBatch_code("B006");
        batchDTO.setPurchase_date(dateFormat.parse("2023-05-25"));
        batchDTO.setExpiry_date(dateFormat.parse("2023-06-25"));
        batchDTO.setProduct_code("P001");
        batchDTO.setBatch_qty(100);
        batchDTO.setAvailable_qty(100);
        batchDTO.setIs_sold(false);

        // Mock the behavior of the BatchRepository
        when(batchRepositoryMock.add(any(Batch.class))).thenReturn(true);

        // Perform the test using the BatchService
        boolean result = batchService.add(batchDTO);

        // Assertions
        assertTrue(result);
        // Additional assertions if needed
    }

    @Test
    public void testUpdate() throws ParseException {
        // Create a BatchDTO object with sample data for testing
        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setBatch_code("B006");
        batchDTO.setPurchase_date(dateFormat.parse("2023-05-26"));
        batchDTO.setExpiry_date(dateFormat.parse("2023-05-27"));
        batchDTO.setProduct_code("P002");
        batchDTO.setBatch_qty(100);
        batchDTO.setAvailable_qty(100);
        batchDTO.setIs_sold(false);

        // Mock the behavior of the BatchRepository
        when(batchRepositoryMock.update(any(Batch.class))).thenReturn(true);

        // Perform the test using the BatchService
        boolean result = batchService.update(batchDTO);

        // Assertions
        assertTrue(result);
        // Additional assertions if needed
    }

    @Test
    public void testDelete() throws Exception {
        String code = "B006";

        // Mock the behavior of the BatchRepository
        when(batchRepositoryMock.delete(code)).thenReturn(true);

        // Perform the test using the BatchService
        boolean result = batchService.delete(code);

        // Assertions
        assertTrue(result);
        // Additional assertions if needed
    }

    // Rest of the test methods
    
    private void setPrivateField(Object targetObject, String fieldName, Object fieldValue) {
        try {
            java.lang.reflect.Field field = targetObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(targetObject, fieldValue);
        } catch (Exception e) {
            Logger.getLogger(BatchServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
}
