/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.core;


import com.syos.pos.repository.dao.IRepositoryDAO;
import com.syos.pos.service.BatchService;

import com.syos.pos.service.ProductService;
import com.syos.pos.service.ShelfService;
import com.syos.pos.service.dao.IServiceDAO;

/**
 *
 * @author senu2k
 */
public class ServiceFactory {
    
    private static ServiceFactory serviceFactory;
    
    private final ProductService productService;
    private final BatchService batchService;
    private final ShelfService shelfService;
//    private final BillHeaderRepository billHeaderRepository;
//    private final BillDetailRepository billDetailfRepository;

    public enum ServiceType {
        PRODUCT, BATCH, SHELF, BILL_HEADER, BILL_DETAIL;
    }
    
    public ServiceFactory() {
        productService = new ProductService();
        batchService = new BatchService();
        shelfService = new ShelfService();
//        billHeaderRepository = new BillHeaderRepository();
//        billDetailfRepository = new BillDetailRepository();
    }
    
    public static ServiceFactory getInstance(){
        
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        
        return serviceFactory;
    }
    
    
    public IServiceDAO getDAO(ServiceType serviceType) {
        switch (serviceType) {
            case PRODUCT:
                return productService;
            case BATCH:
                return batchService;
            case SHELF:
                return shelfService;
//            case BILL_HEADER:
//                return billHeaderRepository;
//            case BILL_DETAIL:
//                return billDetailfRepository;
            default:
                return null;
        }
    }
    
}
