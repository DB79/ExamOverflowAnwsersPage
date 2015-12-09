/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien
 */
public class AnswerDAO {

    private DBConnection cn;
    private Connection conn;
    
    
    public byte[] getVideoAnswer(){
        
        VideoAnswerImpl video=null;
        
        byte[] image=null;
        
        cn = new DBConnection();
        try {
            conn = cn.openConnect();

            Statement stmtInsert;

            String st = "SELECT VIDEO FROM ANSWER WHERE ANSWERID = 18";
            
            stmtInsert = conn.createStatement(); //createStatement(sbInsert.toString());

            JOptionPane.showMessageDialog(null, st);

            ResultSet res = stmtInsert.executeQuery(st);
            if(res.next()){
                    image = res.getBytes("VIDEO");
            }    
            //ImageIcon imageIcon = new ImageIcon(image);
            
            //File imageFile = new File(imageIcon.getImage());
            
            conn.close();
            return image;
            
        } catch (SQLException e) {
            System.out.println("EERROR: " + e.getMessage());
        }

        return null;
    }
    //StringBuilder sbInsert = new StringBuilder();

            //sbInsert.append("SELECT VIDEO ");
            //sbInsert.append("FROM ANSWER ");
            //sbInsert.append("WHERE ANSWERID = 10");
            //sbInsert.append("VALUES");
           //sbInsert.append("(SEQ_ANSWERID.NEXTVAL,?)");

            //VideoAnswerImpl vAnswer = new VideoAnswerImpl();
            //vAnswer.setAnswerID(getNextAnswerID());
    
    
     public DisplayAnswer getAnswer(int answerID) {
        
        ResultSet resSet;
        PreparedStatement stmtSelectt;

        StringBuilder sbSelect = new StringBuilder();

        cn = new DBConnection();
        try {
            conn = cn.openConnect();
            
            sbSelect.append("SELECT ANSWERID,ANSWERTEXT,PROFILEIMAGE,USERNAME,A.LIKES, DATEPOSTED ");
            sbSelect.append("FROM ANSWER A, USERS U ");
            sbSelect.append("WHERE ANSWERID = ? AND A.TNUMBER = U.TNUMBER");

            stmtSelectt = conn.prepareStatement(sbSelect.toString());

            stmtSelectt.setInt(1, answerID);

            resSet = stmtSelectt.executeQuery(); 
            
           
            while(resSet.next())
            { 
                
                DisplayAnswer ans = new DisplayAnswer();
                
                ans.setAnswerID(resSet.getInt("ANSWERID"));
                ans.setAnswerText(resSet.getString("ANSWERTEXT"));
                ans.setUsername(resSet.getString("USERNAME"));
                ans.setLikes(resSet.getInt("LIKES"));
                ans.setDatePosted(resSet.getDate("DATEPOSTED"));
                ans.setProfileImage(resSet.getBytes("PROFILEIMAGE"));
                return ans;
                
            }
            resSet.close();
                        
            stmtSelectt.close();
            conn.close();
            conn = null;
            return null;
            
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void createTextAnswer(TextAnswerImpl answer) {
        
        cn = new DBConnection();
        try {
            conn = cn.openConnect();
            
            PreparedStatement stmtInsert;

            StringBuilder sbInsert = new StringBuilder();

            sbInsert.append("INSERT INTO ");
            sbInsert.append("ANSWER");
            sbInsert.append("(ANSWERID,ANSWERTEXT,TNUMBER,DATEPOSTED,QUESTIONID)");
            sbInsert.append("VALUES");
            sbInsert.append("(?,?,?,?,?)");

            stmtInsert = conn.prepareStatement(sbInsert.toString());

            stmtInsert.setInt(1,answer.getAnswerID());
            stmtInsert.setString(2,answer.getAnswerText());
            stmtInsert.setString(3,answer.getTNumber());
            stmtInsert.setString(4,answer.getDatePosted());
            stmtInsert.setInt(5,answer.getQuestionID());

            int rows = stmtInsert.executeUpdate();

            JOptionPane.showMessageDialog(null, rows);

            if (rows != 1) {
                throw new SQLException("executeUpdate return value: " + rows);
            }

            conn.close();
            cn.close(conn);
        } 
        catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
    }

    public int getNextAnswerID() throws SQLException {

        Connection cnn;
        cn = new DBConnection();
        cnn = cn.openConnect();
        int id;
        Statement stmtSelect;
        ResultSet rs;
        StringBuilder sbSelect = new StringBuilder();
        sbSelect.append("SELECT SEQ_ANSWERID.NEXTVAL");
        sbSelect.append(" FROM DUAL ");
        stmtSelect = cnn.createStatement();
        rs = stmtSelect.executeQuery(sbSelect.toString());
        rs.next();
        id = rs.getInt(1);
        cnn.close();
        cn.close(cnn);

        return id;
    }

    public void createVideoAnswer(VideoAnswerImpl vAnswer){

        File fBlob = vAnswer.getVideo();

        cn = new DBConnection();
        try {
            conn = cn.openConnect();

            PreparedStatement stmtInsert;

            StringBuilder sbInsert = new StringBuilder();

            sbInsert.append("INSERT INTO ");
            sbInsert.append("ANSWER");
            sbInsert.append("(ANSWERID,VIDEO,DATEPOSTED,TNUMBER,QUESTIONID,LIKES)");
            sbInsert.append("VALUES");
            sbInsert.append("(?,?,?,?,?,?)");

            stmtInsert = conn.prepareStatement(sbInsert.toString());

            FileInputStream in=null;
            try {
                in = new FileInputStream(fBlob);
                
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(null, in);
            
            stmtInsert.setInt(1,vAnswer.getAnswerID());
            stmtInsert.setBinaryStream(2, in, (int)fBlob.length());
            stmtInsert.setString(3,vAnswer.getDatePosted());
            stmtInsert.setString(4,vAnswer.getTNumber());
            stmtInsert.setInt(5,vAnswer.getQuestionID());
            stmtInsert.setInt(6,vAnswer.getLikes());
            
            stmtInsert.execute();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void removeAnswer(String tnumber, int ansID){
        
        cn = new DBConnection();
        try {
            conn = cn.openConnect();
            
        CallableStatement cs;
    
        //calls DELETE_ANSWER Procedure
        cs = conn.prepareCall("{ CALL DELETE_ANSWER(?,?) }");

        //populate stored procedure parameters
        cs.setString(1,tnumber );
        cs.setInt(2,ansID);
        
        //execute stored procedure
        cs.execute();
        
        }
        catch (SQLException e) {
            
            if(e.getErrorCode() == 20000){
                JOptionPane.showMessageDialog(null,"You do not have adminisration rights.\n"
                                                 + "Therefore you cannot delete the answer.");
            }
            
            else{
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void userImage(){

        File fBlob = new File("F:/EXAM_OVERFLOW/rsz_2profileimage.png");
        

        JOptionPane.showMessageDialog(null,fBlob.getPath());
        
        cn = new DBConnection();
        try {
            conn = cn.openConnect();

            PreparedStatement stmtInsert;

            StringBuilder sbInsert = new StringBuilder();

            sbInsert.append("UPDATE ");
            sbInsert.append("USERS SET ");
            sbInsert.append("(PROFILEIMAGE)");
            sbInsert.append(" =");
            sbInsert.append("? ");
           // sbInsert.append("WHERE TNUMBER = 'T88898953'");

            stmtInsert = conn.prepareStatement(sbInsert.toString());

            JOptionPane.showMessageDialog(null, sbInsert.toString());

            FileInputStream in=null;
            try {
                in = new FileInputStream(fBlob);
                //stmtInsert.setInt(1, vAnswer.getAnswerID());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
            stmtInsert.setBinaryStream(1, in, (int)fBlob.length());
            
            
            

            
            //int rows;
            stmtInsert.execute();
}catch(Exception e){
            System.out.println(e.getMessage());
}
    }
    
public ResultSet getAnswers(int questionID) throws SQLException {

        ResultSet resSet=null;
        PreparedStatement stmtSelect=null;

        StringBuilder sbSelect = new StringBuilder();

        try {
            cn = new DBConnection();
        
            conn = cn.openConnect();
            
            sbSelect.append("SELECT ANSWERID,ANSWERTEXT ");
            sbSelect.append("FROM ANSWER ");
            sbSelect.append("WHERE QUESTIONID = ? AND ANSWERTEXT IS NOT null");

            stmtSelect = conn.prepareStatement(sbSelect.toString());
        
            stmtSelect.setInt(1, questionID);
            
            //gets the number of rows in the result set
            int rows = stmtSelect.executeUpdate();
             
            //if there are no rows throw an SQLException
            if (rows < 1) {
                throw new SQLException(
                        "executeUpdate return value: " + rows);
            }
            else{
                resSet = stmtSelect.executeQuery();
                return resSet;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        

            
        
    }

}