/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import java.util.Scanner;

/**
 *
 * @author senu2k
 */
public class MenuSystem {
    
    private static UserQueries userQueries;

    public void display() {

        BatchService batchService = new BatchService();
        ProductService productService = new ProductService();
        ShelfService shelfService = new ShelfService();
        OrderService orderService = new OrderService();

        MenuInvoker invoker = new MenuInvoker(batchService, productService, shelfService, orderService);

        Scanner scanner = new Scanner(System.in);

        // Set the userQueries to MySQLUserQueries implementation
        userQueries = new MySQLUserQueries();

        // Register or Login
        User user = null;
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("----- User Authentication -----");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter an option: ");
            String authOption = scanner.nextLine();

            switch (authOption) {
                case "1":
                    System.out.print("Enter username: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();
                    System.out.print("Enter role (Admin/Cashier): ");
                    String registerRole = scanner.nextLine();
                    boolean registrationSuccess = userQueries.registerUser(registerUsername, registerPassword, registerRole);
                    if (registrationSuccess) {
                        System.out.println("Registration successful. Please login.");
                    } else {
                        System.out.println("Registration failed. Please try again.");
                    }
                    break;
                case "2":
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    boolean loginSuccess = userQueries.loginUser(loginUsername, loginPassword);
                    if (loginSuccess) {
                        String userRole = userQueries.getUserRole(loginUsername);
                        if (userRole != null) {
                            if (userRole.equalsIgnoreCase("admin")) {
                                user = new User(loginUsername, loginPassword, new AdminUserType());
                            } else if (userRole.equalsIgnoreCase("cashier")) {
                                user = new User(loginUsername, loginPassword, new CashierUserType());
                            } else {
                                System.out.println("Invalid role. Please try again.");
                                continue;
                            }
                            loggedIn = true;
                        } else {
                            System.out.println("Failed to retrieve user role. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        // get user name
        String loginUsername = user.getUsername();

        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("1. Batch");
            System.out.println("2. Product");
            System.out.println("3. Shelf");
            System.out.println("4. Order");
            System.out.println("5. Exit");
            System.out.print("Enter an option: ");
            String entityOption = scanner.nextLine();

            if (entityOption.equalsIgnoreCase("5")) {
                System.out.println("Exiting the menu...");
                break;
            }

            System.out.println("Choose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Get All");
            System.out.print("Enter an option: ");
            String operationOption = scanner.nextLine();

            
            //get the entity from option get operation from option 
            
            invoker.executeCommand(getEntityFromOption(entityOption), getOperationFromOption(operationOption), userQueries.getUserRole(loginUsername));
            
        }
    }

    private static String getEntityFromOption(String option) {
        switch (option) {
            case "1":
                return "batch";
            case "2":
                return "product";
            case "3":
                return "shelf";
            case "4":
                return "order";
            default:
                return "";
        }
    }

    private static String getOperationFromOption(String option) {
        switch (option) {
            case "1":
                return "add";
            case "2":
                return "update";
            case "3":
                return "delete";
            case "4":
                return "getall";
            default:
                return "";
        }
    }
}
