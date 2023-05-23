/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.ProductDTO;
import java.util.List;
import com.syos.pos.repository.dao.IProductRepository;
import com.syos.pos.service.dao.IProductService;

/**
 *
 * @author senu2k
 */
public class ProductService implements IProductService{
    
    private static final IProductRepository itemRepositoryDAO = (IProductRepository) RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.ITEM);

    @Override
    public boolean add(ProductDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProductDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
