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
//    public  static Connection databaseLink;
//    
//    public static Connection getDBConnection(String username, String password, String serviceName, Integer port_number) throws SQLException{
////        String url1;
////        url1 = "jdbc:oracle:thin:@//NPLSEAPP16.us.oracle.com:1521/OPERA";
//        String url;
//        url = "jdbc:oracle:thin:@//NPLSEAPP16.us.oracle.com:1521/OPERA";
//        System.out.println(url);
//        
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            databaseLink=DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return databaseLink;
//    }
//
//    private String toString(Integer port_number) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public static Connection con;
    
  
    
    public static Connection getDBConnection(String username, String password){
        
		
        try {
            //Register the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println(con==null);
            System.out.println("Registered to the JDBC driver");
            
            //Open the connection
            
            con=DriverManager.getConnection("jdbc:oracle:thin:@//NPLSEAPP16.us.oracle.com:1521/OPERA",username ,password );
//            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","V50600_HOTEL" ,"V50600_HOTEL" );
            
            System.out.println("DriverManager connected to db");
            //jdbc:oracle:thin:@//wfivm01801.us.oracle.com:1521/OPERA
//            con = DriverManager.getConnection("jdbc:oracle:thin:@//NPLSEAPP16.us.oracle.com:1521/OPERA", "SMOKE_ASP", "SMOKE_ASP");


        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception : "+ex);
            //Logger.getLogger(dbCoonectionCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("DFHUDSBFSDF");
        return con;
 
			
		
        
    }

    
}
