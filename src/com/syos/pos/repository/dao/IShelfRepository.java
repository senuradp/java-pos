/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.repository.dao;

import com.syos.pos.entity.Shelf;

/**
 *
 * @author senu2k
 */
public interface IShelfRepository extends IRepositoryDAO<Shelf>{

    // update stock based on parameters product code and qty
    boolean updateShelf(String product_code, double qty) throws Exception;

    // get available qty based on product code
    double getAvailableQty(String product_code) throws Exception;
    
}
