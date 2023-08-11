/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import com.syos.pos.controller.ProductController;
import com.syos.pos.controller.ShelfController;
import com.syos.pos.dto.ShelfDTO;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senu2k
 */
public class ShelfService {
    void add() {
        try {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter shelf code: ");
            String shelf_code = scanner.nextLine();
            
            ShelfController shelfController = new ShelfController();
            if (!shelfController.checkShelfCodeExists(shelf_code)) {
                
                System.out.println("Enter product code: ");
                String product_code = scanner.nextLine();

                double capacity = 0;
                double available_qty = 0;

                boolean validQty = false;
                while (!validQty) {
                    System.out.println("Enter capacity: ");
                    capacity = scanner.nextDouble();
                    System.out.println("Enter available quantity: ");
                    available_qty = scanner.nextDouble();

                    if (available_qty <= capacity) {
                        validQty = true;
                    } else {
                        System.out.println("Available quantity cannot exceed capacity. Please enter a valid quantity.");
                    }
                }

                ShelfDTO shelfDTO = new ShelfDTO();

                try {
                    shelfDTO.setShelf_code(shelf_code);
                    shelfDTO.setProduct_code(product_code);
                    shelfDTO.setCapacity(capacity);
                    shelfDTO.setAvailable_qty(available_qty);
                    shelfController.addItem(shelfDTO);
                    System.out.println("Shelf added successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to add shelf.");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ShelfService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void update() {
        try {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter shelf code: ");
            String shelf_code = scanner.nextLine();
            
            ShelfController shelfController = new ShelfController();
            if (shelfController.checkShelfCodeExists(shelf_code)) {
                System.out.println("Shelf found. Enter '1' to update capacity, '2' to update available quantity, or '0' to cancel: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                
                ShelfDTO shelfDTO = new ShelfDTO();
                shelfDTO.setShelf_code(shelf_code);
                ShelfDTO existingShelf = shelfController.getShelfDetails(shelf_code);
                shelfDTO.setProduct_code(existingShelf.getProduct_code()); // Retain existing product code
                
                switch (option) {
                    case 1:
                         try {
                            shelfDTO.setAvailable_qty(existingShelf.getAvailable_qty()); // Retain existing available qty
                            System.out.println("Enter new capacity: ");
                            double capacity = scanner.nextInt();

                            try {
                                shelfDTO.setShelf_code(shelf_code);
                                shelfDTO.setCapacity(capacity);
                                shelfController.updateItem(shelfDTO);
                                System.out.println("Capacity updated successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Failed to update capacity.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Failed to retrieve existing shelf details.");
                        }
                        break;
                        
                    case 2:
                        try {
                            shelfDTO.setCapacity(existingShelf.getCapacity()); // Retain existing available qty
                            double available_qty = 0;
                            boolean validQty = false;
                            while (!validQty) {
                                System.out.println("Enter new available quantity: ");
                                available_qty = scanner.nextInt();
                                double currentCapacity = shelfController.getShelfCapacity(shelf_code);
                                if (available_qty <= currentCapacity) {
                                    validQty = true;
                                } else {
                                    System.out.println("Available quantity cannot exceed capacity. Please enter a valid quantity.");
                                }
                            }

                            try {
                                shelfDTO.setShelf_code(shelf_code);
                                shelfDTO.setAvailable_qty(available_qty);
                                shelfController.updateItem(shelfDTO);
                                System.out.println("Available quantity updated successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Failed to update available quantity.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Failed to retrieve existing shelf details.");
                        }
                        break;
                        
                    case 0:
                        System.out.println("Update canceled.");
                        break;
                        
                    default:
                        System.out.println("Invalid option. Update canceled.");
                        break;
                }
            } else {
                System.out.println("Shelf not found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ShelfService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void delete() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter shelf code: ");
            String shelf_code = scanner.nextLine();
            
            ShelfController shelfController = new ShelfController();
            if (shelfController.checkShelfCodeExists(shelf_code)) {
                try {
                    shelfController.deleteItem(shelf_code);
                    System.out.println("Shelf deleted successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to delete shelf.");
                }
            } else {
                System.out.println("Shelf not found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ShelfService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void getAll() {
        try {
            ShelfController shelfController = new ShelfController();
            List<ShelfDTO> shelves = shelfController.getAll();
            
            if (!shelves.isEmpty()) {
                System.out.println("All Shelves:");
                for (ShelfDTO shelf : shelves) {
                    System.out.println("Shelf Code: " + shelf.getShelf_code());
                    System.out.println("Product Code: " + shelf.getProduct_code());
                    System.out.println("Capacity: " + shelf.getCapacity());
                    System.out.println("Available Quantity: " + shelf.getAvailable_qty());
                    System.out.println("-----------------------");
                }
            } else {
                System.out.println("No shelves found.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ShelfService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
