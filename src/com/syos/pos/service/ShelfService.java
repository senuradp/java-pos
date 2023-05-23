/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.ShelfDTO;
import com.syos.pos.entity.Shelf;
import com.syos.pos.repository.ShelfRepository;
import com.syos.pos.repository.dao.IShelfRepository;
import com.syos.pos.service.dao.IShelfService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class ShelfService implements IShelfService{
    
    private static final IShelfRepository shelfRepositoryDAO = (IShelfRepository) RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.SHELF);

    @Override
    public boolean add(ShelfDTO shelfDTO) {
        try{
            Shelf shelf = new Shelf();
            shelf.setShelf_code(shelfDTO.getShelf_code());
            shelf.setProduct_code(shelfDTO.getProduct_code());
            shelf.setCapacity(shelfDTO.getCapacity());
            shelf.setProduct_qty(shelfDTO.getProduct_qty());
            
            return shelfRepositoryDAO.add(shelf);
            
        }catch (Exception ex) {
             Logger.getLogger(ShelfRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(ShelfDTO shelfDTO) {
        try{
            Shelf shelf = new Shelf();
            shelf.setShelf_code(shelfDTO.getShelf_code());
            shelf.setProduct_code(shelfDTO.getProduct_code());
            shelf.setCapacity(shelfDTO.getCapacity());
            shelf.setProduct_qty(shelfDTO.getProduct_qty());
            
            return shelfRepositoryDAO.update(shelf);
            
        }catch (Exception ex) {
             Logger.getLogger(ShelfRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        try{
            
            return shelfRepositoryDAO.delete(code);
            
        }catch (Exception ex) {
             Logger.getLogger(ShelfRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ShelfDTO> getAll() throws Exception {
        try{
            List<Shelf> allItems = shelfRepositoryDAO.getAll();
            List<ShelfDTO> allItemDTOs = new ArrayList<>();
            for (Shelf shelf : allItems) {
                ShelfDTO shelfDTO = new ShelfDTO();
                shelf.setShelf_code(shelfDTO.getShelf_code());
                shelf.setProduct_code(shelfDTO.getProduct_code());
                shelf.setCapacity(shelfDTO.getCapacity());
                shelf.setProduct_qty(shelfDTO.getProduct_qty());

                allItemDTOs.add(shelfDTO);

            }
            return allItemDTOs;
        }catch (Exception ex) {
             Logger.getLogger(ShelfRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
