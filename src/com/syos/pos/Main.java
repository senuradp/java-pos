/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.syos.pos.controller.ShelfController;
import com.syos.pos.dto.ProductDTO;
import com.syos.pos.dto.ShelfDTO;

/**
 *
 * @author senu2k
 */
public class Main {
    
    public static void main(String[] args) {
        

        // add a shelf
        ShelfDTO shelfDTO = new ShelfDTO();
        shelfDTO.setShelf_code("S001");
        shelfDTO.setProduct_code("");
        shelfDTO.setCapacity(10);
        shelfDTO.setProduct_qty(5);
        

        try {
            boolean addItem = ShelfController.addItem(shelfDTO);
            if (addItem) {
                System.out.println("Shelf added !");
            } else {
                System.out.println("Ooops...! Something went wrong");
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
