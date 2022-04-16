/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public static Connection getConnection()throws Exception {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/weblog?useUnicode=true&characterEncoding=utf-8", "Weblog", "123");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cons;
    }   
    
    
    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}
