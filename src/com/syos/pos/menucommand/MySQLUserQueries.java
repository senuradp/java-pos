/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syos.pos.menucommand;

import java.sql.ResultSet;

/**
 *
 * @author senu2k
 */
public class MySQLUserQueries implements UserQueries {
    @Override
    public boolean registerUser(String username, String password, String role) {
        // Implement the registration logic using MySQL database
        // Return true if the registration is successful, false otherwise
        // You can use the DBConnection class and executeUpdate method
        try {
            String sql = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
            return RepositoryCRUD.executeUpdate(sql, username, password, role);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean loginUser(String username, String password) {
        // Implement the login logic using MySQL database
        // Return true if the login is successful, false otherwise
        // You can use the DBConnection class and executeQuery method
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            ResultSet resultSet = RepositoryCRUD.executeQuery(sql, username, password);
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getUserRole(String username) {
        // Implement logic to retrieve the user's role from the database
        // You can use the DBConnection class and executeQuery method
        try {
            String sql = "SELECT role FROM user WHERE username = ?";
            ResultSet resultSet = RepositoryCRUD.executeQuery(sql, username);
            if (resultSet.next()) {
                return resultSet.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
