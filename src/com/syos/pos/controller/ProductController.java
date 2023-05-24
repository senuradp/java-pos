/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.controller;

import com.syos.pos.core.RepositoryFactory;
import com.syos.pos.core.ServiceFactory;
import com.syos.pos.dto.ProductDTO;
import com.syos.pos.service.dao.IProductService;
import java.util.List;

/**
 *
 * @author senu2k
 */
public class ProductController {
    
    private static final IProductService productService = (IProductService)ServiceFactory.getInstance().getDAO(ServiceFactory.ServiceType.PRODUCT);

    public static boolean addItem(ProductDTO productDTO){
        return productService.add(productDTO);
    }
    
    public static boolean updateItem(ProductDTO productDTO){
        return productService.update(productDTO);
    }
    
    public static boolean deleteItem(String code) throws Exception{
       return productService.delete(code);
    }

    public static List<ProductDTO> getAll() throws Exception{
        return productService.getAll();
    }
    
}
