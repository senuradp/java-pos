/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.controller;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.BatchDTO;
import com.syos.pos.service.BatchService;
import com.syos.pos.service.dao.IBatchService;
import java.util.List;

/**
 *
 * @author senu2k
 */
public class BatchController {
 
    private static final IBatchService batchService = (IBatchService)RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.BATCH);

    public static boolean addItem(BatchDTO batchDTO){
        return batchService.add(batchDTO);
    }
    
    public static boolean updateItem(BatchDTO batchDTO){
        return batchService.update(batchDTO);
    }
    
    public static boolean deleteItem(String code) throws Exception{
       return batchService.delete(code);
    }

    public static List<BatchDTO> getAll() throws Exception{
        return batchService.getAll();
    }
    
}
