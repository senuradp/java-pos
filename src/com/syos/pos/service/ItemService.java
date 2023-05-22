/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.ItemDTO;
import com.syos.pos.repository.dao.IItemRepository;
import com.syos.pos.service.dao.IItemService;
import java.util.List;

/**
 *
 * @author senu2k
 */
public class ItemService implements IItemService{
    
    private static final IItemRepository itemRepositoryDAO = (IItemRepository) RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.ITEM);

    @Override
    public boolean add(ItemDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ItemDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
