/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.controller;

import com.syos.pos.core.ServiceFactory;
import com.syos.pos.service.dao.IBillDetailService;

/**
 *
 * @author senu2k
 */
public class BillDetailController {
    
    private static final IBillDetailService billDetailService = (IBillDetailService)ServiceFactory.getInstance().getDAO(ServiceFactory.ServiceType.BILL_HEADER);
    
}
