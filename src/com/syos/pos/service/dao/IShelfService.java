/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.dao;

import com.syos.pos.dto.ShelfDTO;

/**
 *
 * @author senu2k
 */
public interface IShelfService extends IServiceDAO<ShelfDTO>{

    public boolean updateShelf(String product_code, double qty);

    public double getAvailableQty(String product_code);
    
}
