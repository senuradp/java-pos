/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.repository;

import com.syos.pos.core.RepositoryCRUD;
import com.syos.pos.entity.Batch;
import com.syos.pos.entity.Product;
import com.syos.pos.entity.Shelf;
import com.syos.pos.repository.dao.IShelfRepository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class ShelfRepository implements IShelfRepository{

    @Override
    public boolean add(Shelf shelf) {
        try{
            return RepositoryCRUD.executeUpdate("INSERT INTO shelf VALUES(?,?,?,?)", shelf.getShelf_code(), shelf.getProduct_code(), shelf.getCapacity(), shelf.getAvailable_qty());
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Shelf shelf) {
        try{
            return RepositoryCRUD.executeUpdate("UPDATE shelf SET shelf_code=?, product_code=?, capacity=?, available_qty=? WHERE shelf_code=?" ,shelf.getShelf_code(), shelf.getProduct_code(), shelf.getCapacity(), shelf.getAvailable_qty(), shelf.getShelf_code());
            
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        try{
            return RepositoryCRUD.executeUpdate("DELETE FROM shelf WHERE shelf_code = ?", code);
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Shelf> getAll() throws Exception {
        
        ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM shelf");
        List<Shelf> arrayList = new ArrayList<>();
        while (rst.next()) {
            Shelf shelfs = new Shelf();
            shelfs.setShelf_code(rst.getString(1));
            shelfs.setProduct_code(rst.getString(2));
            shelfs.setCapacity(rst.getDouble(3));
            shelfs.setAvailable_qty(rst.getDouble(4));
                        
            arrayList.add(shelfs);
        }
        
        return arrayList;
        
    }

    @Override
    public boolean updateShelf(String product_code, double qty) throws Exception {
        try{
            // return RepositoryCRUD.executeUpdate("UPDATE shelf SET available_qty = available_qty - ? WHERE product_code = ?", qty, product_code);
            // check if enough items in the shelf then update shelf
            ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM shelf WHERE product_code = ?", product_code);
            if (rst.next()) {
                double available_qty = rst.getDouble(4);
                if (available_qty >= qty) {
                    return RepositoryCRUD.executeUpdate("UPDATE shelf SET available_qty = available_qty - ? WHERE product_code = ?", qty, product_code);
                } else {
                    return false;
                }
            } else {
                return false;
            }


        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public double getAvailableQty(String product_code) throws Exception {
        try{
            ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM shelf WHERE product_code = ?", product_code);
            // what is rst.next() 
            // rst.next() is a boolean value
            // if there is a value in the result set then rst.next() will return true else false

            if (rst.next()) {
                return rst.getDouble(4);
            } else {
                return 0;
            }
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public String getBatchCode(String product_code) throws Exception {
        try{
            ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM batch WHERE product_code = ?", product_code);
            // get the batch code that is in shelf
            if (rst.next()) {
                return rst.getString(1);
            } else {
                return null;
            }
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean checkExpiryDate(String product_code, String batch_code) throws Exception {
        try{
            ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM batch WHERE batch_code = ? AND product_code = ?", batch_code, product_code);
            if (rst.next()) {
                // check if expiry date is closer to todays date
                Date expiry_date = rst.getDate(3);
                Date today = new Date();
                if (expiry_date.compareTo(today) > 0) { 
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean reStockShelf(String product_code, double qty) throws Exception {
        try{

            // check if shelf available qty< shelf capacity
            ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM shelf WHERE product_code = ?", product_code);
            if (rst.next()) {
                // using the getAvailableQty get the available qty of the shelf
                double available_qty = getAvailableQty(product_code); 
                double capacity = rst.getDouble(3); // capacity of the shelf
                if (available_qty < capacity){

                    // get all the batches by product code and assign to a list
                    List<Batch> batches = new ArrayList<>();
                    ResultSet rst2 = RepositoryCRUD.executeQuery("SELECT * FROM batch WHERE product_code = ?", product_code);
                    while (rst2.next()) {
                        Batch batch = new Batch();
                        batch.setBatch_code(rst2.getString(1));
                        batch.setPurchase_date(rst2.getDate(2));
                        batch.setExpiry_date(rst2.getDate(3));
                        batch.setProduct_code(rst2.getString(4));
                        batch.setBatch_qty(rst2.getDouble(5));
                        batch.setAvailable_qty(rst2.getDouble(6));
                        batch.setIs_sold(rst2.getBoolean(7));
                        batches.add(batch);
                    }

                    // create 2 lists and add expired batches to 1 lista nd the ones not expired to another
                    List<Batch> expired_batches = new ArrayList<>();
                    List<Batch> not_expired_batches = new ArrayList<>();
                    
                    // sort the batches in ascending order by purachse date
                    // check if the batch is expired or not
                    // if expired add to expired_batches list else add to not_expired_batches list

                    Collections.sort(batches, new Comparator<Batch>() {
                        @Override
                        public int compare(Batch b1, Batch b2) {
                            return b1.getExpiry_date().compareTo(b2.getExpiry_date());
                        }
                    });

                    for (Batch batch : batches) {
                        if (checkExpiryDate(product_code, batch.getBatch_code())) {
                            expired_batches.add(batch);
                        } else {
                            not_expired_batches.add(batch);
                        }
                    }

                    // sort the not expired batches with oldest purchase date first and check the available qty of the oldest purchase date batch

                    Collections.sort(not_expired_batches, new Comparator<Batch>() {
                        @Override
                        public int compare(Batch b1, Batch b2) {
                            return b1.getPurchase_date().compareTo(b2.getPurchase_date());
                        }
                    });

                    // get the available qty of the oldest purchase date batch
                    // double available_qty_oldest_batch = not_expired_batches.get(0).getAvailable_qty();     

                    boolean restocked = false;

                    for (Batch batch : not_expired_batches) {
                        double available_qty_batch = batch.getAvailable_qty();
                        
                        if (available_qty_batch < qty) {
                            // Restock the available quantity of the current batch
                            RepositoryCRUD.executeUpdate("UPDATE shelf SET available_qty = available_qty + ? WHERE product_code = ?", available_qty_batch, product_code);
                            RepositoryCRUD.executeUpdate("UPDATE batch SET available_qty = 0 WHERE batch_code = ?", batch.getBatch_code()); 
                            qty -= available_qty_batch; // Update the remaining quantity to restock 

                            // Move to the next oldest batch
                        } else {
                            // Restock the desired quantity from the current batch
                            RepositoryCRUD.executeUpdate("UPDATE shelf SET available_qty = available_qty + ? WHERE product_code = ?", qty, product_code); 
                            RepositoryCRUD.executeUpdate("UPDATE batch SET available_qty = available_qty - ? WHERE batch_code = ?", qty, batch.getBatch_code()); 
                            restocked = true; // Mark as restocked
                            break; // Exit the loop since desired quantity is restocked

                        }
                    }

                    return restocked;

                }else{
                    return false;
                }
            } else {
                return false;
            }
            
        }catch(Exception ex){
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
