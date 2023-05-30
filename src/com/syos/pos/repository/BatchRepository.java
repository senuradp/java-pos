/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.repository;

import com.syos.pos.core.RepositoryCRUD;
import com.syos.pos.entity.Batch;
import com.syos.pos.repository.dao.IBatchRepository;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class BatchRepository implements IBatchRepository{

    @Override
    public boolean add(Batch batch) {
        try{
            return RepositoryCRUD.executeUpdate("INSERT INTO batch VALUES(?,?,?,?,?,?,?)", batch.getBatch_code(), batch.getPurchase_date(), batch.getExpiry_date(), batch.getProduct_code(), batch.getBatch_qty(), batch.getAvailable_qty(), batch.getIs_sold());
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(Batch batch) {
        try{
            return RepositoryCRUD.executeUpdate("UPDATE batch SET batch_code=?, purchase_date=?,expiry_date=?,product_code=?, batch_qty=?, available_qty=?, is_sold=? WHERE product_code=?" ,batch.getBatch_code(), batch.getPurchase_date(), batch.getExpiry_date(), batch.getProduct_code(), batch.getBatch_qty(), batch.getAvailable_qty(), batch.getIs_sold(), batch.getBatch_code());
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        try{
            return RepositoryCRUD.executeUpdate("DELETE FROM batch WHERE batch_code = ?", code);
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<Batch> getAll() throws Exception {
        ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM batch");
        List<Batch> arrayList = new ArrayList<>();
        while (rst.next()) {
            Batch batches = new Batch();
            batches.setBatch_code(rst.getString(1));
            batches.setPurchase_date(rst.getDate(2));
            batches.setExpiry_date(rst.getDate(3));
            batches.setProduct_code(rst.getString(4));
            batches.setBatch_qty(rst.getDouble(5));
            batches.setAvailable_qty(rst.getDouble(6));
            batches.setIs_sold(rst.getBoolean(7));
            
            
            arrayList.add(batches);
        }
        
        return arrayList;
    }

    // @Override
    // public boolean updateBatchQty(String product_code, double qty) throws Exception {
    //     try{
    //         // update batch qty for product code
    //         return RepositoryCRUD.executeUpdate("UPDATE batch SET available_qty=? WHERE product_code=?", qty, product_code);

    //     }catch (Exception ex) {
    //          Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    //     return false;
    // }
    
}
