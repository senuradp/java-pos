/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service.dao;

import com.syos.pos.dto.BatchDTO;

/**
 *
 * @author senu2k
 */
public interface IBatchService extends IServiceDAO<BatchDTO>{
    
    // update batch qty by product code
    // boolean updateBatchQty(String product_code, double qty) throws Exception;

}
