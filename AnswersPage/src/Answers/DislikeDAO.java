/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien
 */
public class DislikeDAO {
    public void createDislike(Dislike dislike){
        
        Connection conn=null;
    
        DBConnection cn = new DBConnection();
        
        try {
        conn = cn.openConnect();
        
        PreparedStatement stmtInsert;

        StringBuilder sbInsert = new StringBuilder();

        sbInsert.append("INSERT INTO ");
        sbInsert.append("DISLIKES");
        sbInsert.append(" VALUES");
        sbInsert.append("(?,?)");

        stmtInsert = conn.prepareStatement(sbInsert.toString());
       
        stmtInsert.setString(1,dislike.getTNumber());
        stmtInsert.setInt(2,dislike.getAnswerID());
        
        int rows = stmtInsert.executeUpdate();

        JOptionPane.showMessageDialog(null, rows);

        if (rows != 1) {
            throw new SQLException("executeUpdate return value: " + rows);
        }
        
        JOptionPane.showMessageDialog(null,"Your dislike has been recorded");
        
        } catch (SQLException ex) {

            if (ex.getErrorCode() == 00001) {
                JOptionPane.showMessageDialog(null, "You have already disliked this answer.");
            }
            //System.out.println("ERROR" + ex.getMessage());
        }

        
        cn.close(conn);
    }
    
}
