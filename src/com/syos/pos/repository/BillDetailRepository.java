/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.repository;

import com.syos.pos.core.RepositoryCRUD;
import com.syos.pos.entity.BillDetail;
import com.syos.pos.repository.dao.IBillDetailRepository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class BillDetailRepository implements IBillDetailRepository{

    @Override
    public boolean add(BillDetail billDetail) {
            
        try {
            return RepositoryCRUD.executeUpdate("INSERT INTO bill_detail VALUES(?,?,?,?,?)", billDetail.getBill_serial_number(), billDetail.getItem_name(), billDetail.getItem_qty(), billDetail.getItem_price(), billDetail.getTotal_item_price());
        } catch (Exception ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }

    @Override
    public boolean update(BillDetail billDetail) {
        try {
            return RepositoryCRUD.executeUpdate("UPDATE bill_detail SET bill_serial_number=?, product_name=?, product_qty=?, product_price=?, total_bill_price=? WHERE bill_serial_number=?",billDetail.getBill_serial_number(), billDetail.getItem_name(), billDetail.getItem_qty(), billDetail.getItem_price(), billDetail.getTotal_item_price(),billDetail.getBill_serial_number());
        } catch (Exception ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String bill_serial_number) throws Exception {
        try{
            return RepositoryCRUD.executeUpdate("DELETE FROM bill_detail WHERE bill_serial_number = ?", bill_serial_number);
        } catch (Exception ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<BillDetail> getAll() throws Exception {
        ResultSet rst = RepositoryCRUD.executeQuery("SELECT * FROM bill_detail");
        List<BillDetail> arrayList = new ArrayList<>();
        while (rst.next()) {
            BillDetail billDetails = new BillDetail();
            billDetails.setBill_serial_number(rst.getString(1));
            billDetails.setItem_name(rst.getString(2));
            billDetails.setItem_qty(rst.getDouble(3));
            billDetails.setItem_price(rst.getDouble(4));
            billDetails.setTotal_item_price(rst.getDouble(5));
            
            
            arrayList.add(billDetails);
        }
        
        return arrayList;
    }
    
}
