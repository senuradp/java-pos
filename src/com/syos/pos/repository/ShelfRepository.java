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
            return RepositoryCRUD.executeUpdate("INSERT INTO shelf VALUES(?,?,?,?,?)", 0, shelf.getShelf_code(), shelf.getProduct_code(), shelf.getCapacity(), shelf.getProduct_qty());
        }catch(Exception ex){
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Shelf shelf) {
        try{
                        return RepositoryCRUD.executeUpdate("UPDATE shelf SET shelf_code=?, shelf_code=?, capacity=?, product_qty=? WHERE shelf_code=?" ,shelf.getShelf_code(), shelf.getProduct_code(), shelf.getCapacity(), shelf.getProduct_qty(), shelf.getShelf_code());
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
            shelfs.setProduct_qty(rst.getDouble(4));
                        
            arrayList.add(shelfs);
        }
        
        return arrayList;
        
    }
    
}
