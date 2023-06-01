/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author senu2k
 */
public class FacadeReportTest {
    
    private static FacadeReport facadeReport;
    private IReport billReport, shelfReport, salesReport, stockReport, result;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public FacadeReportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        facadeReport = new FacadeReport();
    }
    
    @AfterClass
    public static void tearDownClass() {
        facadeReport = null;
    }
    
    @Before
    public void setUp() {
        billReport = new BillReport();
        shelfReport = new ShelfReport();
        salesReport = new SalesReport();
        stockReport = new StockReport();
    }
    
    @After
    public void tearDown() {
        billReport = null;
        shelfReport = null;
        salesReport = null;
        stockReport = null;
    }
    
   @Test
    public void testGetBillReport() {
        System.out.println("getBillReport");
        IReport result = facadeReport.getBillReport();
        assertNotNull(result);
        // TODO: Add specific assertions for the bill report
    }

    /**
     * Test of getShelfReport method, of class FacadeReport.
     */
    @Test
    public void testGetShelfReport() {
        System.out.println("getShelfReport");
        result = facadeReport.getShelfReport();
        assertNotNull(result);
        // TODO: Add specific assertions for the shelf report
    }

    /**
     * Test of getSalesReport method, of class FacadeReport.
     */
    @Test
    public void testGetSalesReport() {
        System.out.println("getSalesReport");
        result = facadeReport.getSalesReport();
        assertNotNull(result);
        // TODO: Add specific assertions for the sales report
    }

    /**
     * Test of getStockReport method, of class FacadeReport.
     */
    @Test
    public void testGetStockReport() {
        System.out.println("getStockReport");
        result =  facadeReport.getStockReport();
        assertNotNull(result);
        // TODO: Add specific assertions for the stock report
    }
    
    /**
     * Test of generateReportByDate method in SalesReport, of class FacadeReport.
     */
    @Test
    public void testGenerateSalesReportByDate() {
        try {
            System.out.println("generateSalesReportByDate");
            String date = "2023-05-31";
            facadeReport.getSalesReport().generateReportByDate(dateFormat.parse(date));
            
        } catch (ParseException ex) {
            Logger.getLogger(FacadeReportTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of generateReportByDate method in StockReport, of class FacadeReport.
     */
    @Test
    public void testGenerateStockReportByDate() {
        try {
            System.out.println("generateStockReportByDate");
            String date = "2023-05-31";
            facadeReport.getStockReport().generateReportByDate(dateFormat.parse(date));

        } catch (ParseException ex) {
            Logger.getLogger(FacadeReportTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
