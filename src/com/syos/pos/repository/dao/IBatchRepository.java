/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.repository.dao;

import com.syos.pos.entity.Batch;
import com.syos.pos.entity.Product;

/**
 *
 * @author senu2k
 */
public interface IBatchRepository extends IRepositoryDAO<Batch>{
    
    // update batch qty by product code
    // boolean updateBatchQty(String product_code, double qty) throws Exception;

}
