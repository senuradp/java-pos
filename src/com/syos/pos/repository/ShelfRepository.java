/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.repository;

import com.syos.pos.core.RepositoryCRUD;
import com.syos.pos.entity.Product;
import com.syos.pos.entity.Shelf;
import com.syos.pos.repository.dao.IShelfRepository;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
}
