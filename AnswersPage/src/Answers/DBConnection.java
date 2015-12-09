/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Answers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author t00171168
 */
public class DBConnection {
    
    Connection conn=null;
    
    
    public Connection openConnect(){
        
     
    try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
      //load the oracle driver...needs to be in classes folder in jre folder
    }
    catch(ClassNotFoundException e) {
      System.out.println(
       " Can't find class oracle.jdbc.driver.OracleDriver");
      System.exit(1);
    }
    
  
    try{
       
        conn = DriverManager.getConnection("jdbc:oracle:thin:@studentoracle.students.ittralee.ie:1521/orcl",
                 "t00171168","p9udna7n");
        
        
        return conn;
    }
    catch(Exception w ){
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl.168.5.67",
                    "hr","hr");
           
            return conn;
        } 
        
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Unable to connect to database");
        }
        
    }
     return conn;   
    }
    
    public void close(Connection conn){
        try{conn.close();
    }
    catch(Exception x){
    }
        
    }
           
    
   
   
        
    
    
}
        
    
    


