/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.controller;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.core.ServiceFactory;
import com.syos.pos.dto.BatchDTO;
import com.syos.pos.service.BatchService;
import com.syos.pos.service.dao.IBatchService;
import java.util.List;

/**
 *
 * @author senu2k
 */
public class BatchController {
 
    private static final IBatchService batchService = (IBatchService)ServiceFactory.getInstance().getDAO(ServiceFactory.ServiceType.BATCH);

    public static boolean addBatch(BatchDTO batchDTO){
        return batchService.add(batchDTO);
    }
    
    public static boolean updateBatch(BatchDTO batchDTO){
        return batchService.update(batchDTO);
    }
    
    public static boolean deleteBatch(String code) throws Exception{
       return batchService.delete(code);
    }

    public static List<BatchDTO> getAll() throws Exception{
        return batchService.getAll();
    }
    
    // udpate batch qty
    // public static boolean updateBatchQty(String product_code, double qty) throws Exception{
    //     return batchService.updateBatchQty(product_code, qty);
    // }

}
