/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.service;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.dto.ProductDTO;
import com.syos.pos.entity.Product;
import com.syos.pos.repository.ProductRepository;
import java.util.List;
import com.syos.pos.repository.dao.IProductRepository;
import com.syos.pos.service.dao.IProductService;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class ProductService implements IProductService{
    
    private static final IProductRepository productRepositoryDAO = (IProductRepository) RepositoryFactory.getInstance().getDAO(RepositoryFactory.RepositoryType.PRODUCT);

    @Override
    public boolean add(ProductDTO productDTO) {
        
        try{
            Product product = new Product();
            product.setProduct_code(productDTO.getProduct_code());
            product.setProduct_batch(productDTO.getProduct_batch());
            product.setProduct_name(productDTO.getProduct_name());
            product.setProduct_price(productDTO.getProduct_price());
            product.setShelf_qty(productDTO.getShelf_qty());
            
            return productRepositoryDAO.add(product);
            
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean update(ProductDTO productDTO) {
            
        try{
            Product product = new Product();
            product.setProduct_code(productDTO.getProduct_code());
            product.setProduct_batch(productDTO.getProduct_batch());
            product.setProduct_name(productDTO.getProduct_name());
            product.setProduct_price(productDTO.getProduct_price());
            product.setShelf_qty(productDTO.getShelf_qty());

            return productRepositoryDAO.update(product);
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        
        try{
            return productRepositoryDAO.delete(code);
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public List<ProductDTO> getAll() throws Exception {
        
        try{
            List<Product> allItems = productRepositoryDAO.getAll();
            List<ProductDTO> allItemDTOs = new ArrayList<>();
            for (Product product : allItems) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProduct_code(product.getProduct_code());
                productDTO.setProduct_batch(product.getProduct_batch());
                productDTO.setProduct_name(product.getProduct_name());
                productDTO.setProduct_price(product.getProduct_price());
                productDTO.setShelf_qty(product.getShelf_qty());

                allItemDTOs.add(productDTO);

            }
            return allItemDTOs;
        }catch (Exception ex) {
             Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
                
    }
    
}
