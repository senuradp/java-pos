/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.shelf;

import com.syos.pos.dto.ShelfDTO;
import com.syos.pos.service.ShelfService;
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
public class ShelfServiceTest {
    
    private static ShelfService shelfService;
    private ShelfDTO testShelfDTO;
    
    public ShelfServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        shelfService = new ShelfService();
    }
    
    @AfterClass
    public static void tearDownClass() {
        shelfService = null;
    }
    
    @Before
    public void setUp() {
        testShelfDTO = new ShelfDTO();
        // Set up the test ShelfDTO object with sample data
        testShelfDTO.setShelf_code("S006");
        testShelfDTO.setProduct_code("P004");
        testShelfDTO.setCapacity(100);
        testShelfDTO.setAvailable_qty(90);
    }
    
    @After
    public void tearDown() {
        testShelfDTO = null;
    }

    @Test
    public void a_testAdd() {
        boolean result = shelfService.add(testShelfDTO);
        assertTrue(result);
    }

    @Test
    public void b_testUpdate() {
        boolean result = shelfService.update(testShelfDTO);
        assertTrue(result);
    }

    @Test
    public void c_testDelete() throws Exception {
        String code = testShelfDTO.getShelf_code();
        boolean result = shelfService.delete(code);
        assertTrue(result);
    }

    @Test
    public void d_testGetAll() throws Exception {
        List<ShelfDTO> allShelfDTOs = shelfService.getAll();
        assertNotNull(allShelfDTOs);
        assertFalse(allShelfDTOs.isEmpty());
    }

    @Test
    public void e_testUpdateShelf() {
        String product_code = "P001";
        double qty = 20;
        boolean result = shelfService.updateShelf(product_code, qty);
        assertTrue(result);
    }

    @Test
    public void f_testGetAvailableQty() {
        String product_code = "P001";
        double expectedQty = 20;
        double resultQty = shelfService.getAvailableQty(product_code);
        assertEquals(expectedQty, resultQty, 0);
    }

    @Test
    public void g_testCheckExpiryDate() {
        String product_code = "P001";
        String batch_code = "B001";
        boolean result = shelfService.checkExpiryDate(product_code, batch_code);
        assertFalse(result);
    }

    @Test
    public void h_testReStockShelf() {
        String product_code = "P001";
        double qty = 5;
        boolean result = shelfService.reStockShelf(product_code, qty);
        assertFalse(result);
    }

    @Test
    public void i_testGetBatchCode() {
        String product_code = "P001";
        String expectedBatchCode = "B001";
        String resultBatchCode = shelfService.getBatchCode(product_code);
        assertEquals(expectedBatchCode, resultBatchCode);
    }
    
}
