/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.report;

import java.util.Date;

/**
 *
 * @author senu2k
 */
public interface IReport {
    
    void generateReport();
    void generateReportByDate(Date date);
    
}
