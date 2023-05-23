/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.controller;

import java.util.List;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.ShelfDTO;
import com.syos.pos.service.ShelfService;

/**
 *
 * @author senu2k
 */
public class ShelfController {
    
    private static final ShelfService shelfService = (ShelfService)RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.SHELF);

    public static boolean addItem(ShelfDTO shelfDTO) throws Exception {
        return shelfService.add(shelfDTO);
    }
    
    public static boolean updateItem(ShelfDTO shelfDTO) throws Exception{
        return shelfService.update(shelfDTO);
    }
    
    public static boolean deleteItem(String code) throws Exception{
       return shelfService.delete(code);
    }

    public static List<ShelfDTO> getAll() throws Exception{
        return shelfService.getAll();
    }
    
}
