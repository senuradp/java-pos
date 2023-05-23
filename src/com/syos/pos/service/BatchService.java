/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.BatchDTO;
import com.syos.pos.entity.Batch;
import com.syos.pos.repository.BatchRepository;
import com.syos.pos.repository.dao.IBatchRepository;
import com.syos.pos.service.dao.IBatchService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class BatchService implements IBatchService{
    
    private static final IBatchRepository batchRepositoryDAO = (IBatchRepository) RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.BATCH);

    @Override
    public boolean add(BatchDTO batchDTO) {
        try{
            Batch batch = new Batch();
            batch.setBatch_code(batchDTO.getBatch_code());
            batch.setPurchase_date(batchDTO.getPurchase_date());
            batch.setExpiry_date(batchDTO.getExpiry_date());
            batch.setProduct_code(batchDTO.getProduct_code());
            batch.setBatch_qty(batchDTO.getBatch_qty());
            batch.setAvailable_qty(batchDTO.getAvailable_qty());
            batch.setShelf_status(batchDTO.isShelf_status());
            
            return batchRepositoryDAO.add(batch);
            
        }catch (Exception ex) {
             Logger.getLogger(BatchRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(BatchDTO batchDTO) {
        
        try{
            Batch batch = new Batch();
            batch.setBatch_code(batchDTO.getBatch_code());
            batch.setPurchase_date(batchDTO.getPurchase_date());
            batch.setExpiry_date(batchDTO.getExpiry_date());
            batch.setProduct_code(batchDTO.getProduct_code());
            batch.setBatch_qty(batchDTO.getBatch_qty());
            batch.setAvailable_qty(batchDTO.getAvailable_qty());
            batch.setShelf_status(batchDTO.isShelf_status());
            
            return batchRepositoryDAO.update(batch);
            
        }catch (Exception ex) {
             Logger.getLogger(BatchRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }

    @Override
    public boolean delete(String code) throws Exception {
        
        try{
            
            return batchRepositoryDAO.delete(code);
            
        }catch (Exception ex) {
             Logger.getLogger(BatchRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public List<BatchDTO> getAll() throws Exception {
        
        try{
            List<Batch> allItems = batchRepositoryDAO.getAll();
            List<BatchDTO> allItemDTOs = new ArrayList<>();
            for (Batch batch : allItems) {
                BatchDTO batchDTO = new BatchDTO();
                batchDTO.setBatch_code(batch.getBatch_code());
                batchDTO.setPurchase_date(batch.getPurchase_date());
                batchDTO.setExpiry_date(batch.getExpiry_date());
                batchDTO.setProduct_code(batch.getProduct_code());
                batchDTO.setBatch_qty(batch.getBatch_qty());
                batchDTO.setAvailable_qty(batch.getAvailable_qty());
                batchDTO.setShelf_status(batch.isShelf_status());

                allItemDTOs.add(batchDTO);

            }
            return allItemDTOs;
        }catch (Exception ex) {
             Logger.getLogger(BatchRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
}
