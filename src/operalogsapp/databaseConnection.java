/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operalogsapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author absasahu
 */
public class databaseConnection {
    public static Connection con;
    public static Connection getDBConnection(String username, String password, Integer portNumber, String serviceName){	
        try {
            //Register the JDBC driver
           System.out.println("before className"); 
            Class.forName("org.sqlite.JDBC");
            System.out.println(con==null);
            System.out.println("Registered to the JDBC driver");
            
            //Open the connection
            if("V50700_HOTEL".equals(username) && "V50700_HOTEL".equals(password) && portNumber==1521 && "opera".equals(serviceName)){
//                con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\absasahu\\Documents\\db\\sqlite.db");
//                    String url = "jdbc:sqlite:sqlite.db";
//                    con= DriverManager.getConnection(url);
//                    con= DriverManager.getConnection("https:\\www.webtiksolutions.com\\assets\\db\\sqlite.db");
//                   con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\absasahu\\Documents\\GitHub\\CollegeProject\\src\\operalogsapp\\sqlite.db");
 con=DriverManager.getConnection("jdbc:sqlite:sqlite.db");
                System.out.println("DriverManager connected to db");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception : "+ex);
            //Logger.getLogger(dbCoonectionCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("DFHUDSBFSDF");
        return con;  
    }

    
}
