/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien
 */
public class LikeDAO {
    
    public void createLike(Like like){
        
        Connection conn=null;
    
        DBConnection cn = new DBConnection();
        
        try {
        conn = cn.openConnect();
        
        PreparedStatement stmtInsert;

        StringBuilder sbInsert = new StringBuilder();

        sbInsert.append("INSERT INTO ");
        sbInsert.append("LIKES");
        sbInsert.append(" VALUES");
        sbInsert.append("(?,?)");

        stmtInsert = conn.prepareStatement(sbInsert.toString());
       
        stmtInsert.setString(1,like.getTNumber());
        stmtInsert.setInt(2,like.getAnswerID());
        
        int rows = stmtInsert.executeUpdate();

        if (rows != 1) {
            throw new SQLException("executeUpdate return value: " + rows);
        
        }
        
        JOptionPane.showMessageDialog(null,"Your like has been recorded.");
        } catch (SQLException ex) {
            
            if(ex.getErrorCode() == 00001){
                JOptionPane.showMessageDialog(null,"You have already liked this answer.");
            }
            
            //System.out.println("ERROR" + ex.getMessage());
        }

        cn.close(conn);
        //JOptionPane.showMessageDialog(null,"Your like has been recorded.");
    }
    
}
