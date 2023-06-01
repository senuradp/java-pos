/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author senu2k
 */
public class MenuInvoker {
     private final Map<String, Command> commands;

    MenuInvoker(BatchService batchService, ProductService productService, ShelfService shelfService, OrderService orderService) {
        commands = new HashMap<>();
        commands.put("add", new AddCommand(batchService, productService, shelfService, orderService));
        commands.put("update", new UpdateCommand(batchService, productService, shelfService, orderService));
        commands.put("delete", new DeleteCommand(batchService, productService, shelfService, orderService));
        commands.put("getall", new GetAllCommand(batchService, productService, shelfService, orderService));
    }

    void executeCommand(String entity, String operation, String userType) {
        if (commands.containsKey(operation)) {
            Command command = commands.get(operation);
            if (command instanceof AddCommand) {
                ((AddCommand) command).entity = entity;
            } else if (command instanceof UpdateCommand) {
                ((UpdateCommand) command).entity = entity;
            } 
            // if user type is cashier dont dive access to this
            if (userType.equals("cashier")) {
                if (command instanceof DeleteCommand) {
                    System.out.println("You don't have access to this operation!");
                    return;
                }
            }
            else if (command instanceof GetAllCommand) {
                ((GetAllCommand) command).entity = entity;
            }
            command.execute();
        } else {
            System.out.println("Invalid operation!");
        }
    }
    
}
