/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien
 */
public class Tester {
    
    public static void main(String args[]){
        
       /*DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy");
       
       Calendar cal = Calendar.getInstance();
       String strdate = dateFormat.format(cal.getTime());
       System.out.println(strdate); //2014/08/06 16:00:22
       */
        
 /*AnswerDAO ans = new AnswerDAO();
 Collection<GenericAnswer> res = ans.getAnswers(1);
 if(res==null){       
 }
 else{
 
 for(GenericAnswer cur : res) {
            System.out.println(cur.toString());
        }
 }*/
        
     AnswerDAO ans = new AnswerDAO();
     
        //try {
            /*DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
            Calendar cal = Calendar.getInstance();
            String datePosted = dateFormat.format(cal.getTime());
            TextAnswerImpl an = new TextAnswerImpl();
            //= new TextAnswerImpl(6,"OOP is about objects","T00171168",datePosted,0,2);
            an.setAnswerID(6);
            an.setAnswerText("OOP is about objects");
            an.setTNumber("T00171168");
            an.setDatePosted(datePosted);
            an.setLikes(0);
            an.setQuestionID(2);
            ans.createTextAnswer(an);
            */
            /* Connection conn;
            try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //load the oracle driver...needs to be in classes folder in jre folder
            }
            catch(ClassNotFoundException e) {
            System.out.println(
            " Can't find class oracle.jdbc.driver.OracleDriver");
            System.exit(0);
            }
            try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl.168.5.67",
            "hr","hr");
            }
            catch(Exception m){System.out.println(m.getMessage());
            System.exit(0);
            }
            String findID = "select seq_answerid.nextval from dual;";
            int nxtID=0;
            PreparedStatement stmtSelect=null;
            ResultSet rs;
            //] = conn.createStatement();
            try{
            rs = stmtSelect.executeQuery(findID);
            nxtID = rs.getInt(1);
            }
            catch(Exception e){
            System.out.println(e.getMessage());
            }
            System.out.println("mmm" + nxtID + "yes");
            */
            //AnswerDAO a = new AnswerDAO();
            //a.getAnswers(2);
            //Connect t = new Connect();
            //t.openConnect();
            /*Blob b = null;
            try {
            a.createVideoAnswer(b);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            // AnswerDAO ans = new AnswerDAO();
            // Collection<DisplayAnswer> col = ans.getAnswers(2);
            // for(DisplayAnswer d:col){
            //    d.toString();
            //@SuppressWarnings("UnusedAssignment")
            // ArrayList<DisplayAnswer> answers = new ArrayList();
            
            /*answers = ans.getAnswers(2);
            try{
            for(DisplayAnswer an: answers){
            an.toString();
            }
            }
            catch(NullPointerException n)
            {
            System.out.println(Arrays.toString(n.getStackTrace()));
            }
            /*Iterator it = answers.iterator();
            
            while(it.hasNext()){
            System.out.println(it.next().toString());
            }
            */
            
            /*System.out.println(ans.getAnswers(2).toString());
            
            System.out.println(ans.getNextAnswerID());
        } catch (SQLException ex) {
           Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
           
    
     
        
        
        
       /* try {
           
            b.createVideoAnswer();
        } 
        catch(FileNotFoundException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
     */
       // b.removeAnswer("",0);
       //Graphics g;
       //g.drawImage(icon,0,0,200,200,null);
       
     
       AnswerDAO b = new AnswerDAO();
       b.userImage();
       
       //byte[] image = b.getVideoAnswer();
       //ImageIcon icon = new ImageIcon(image);

       //JOptionPane.showMessageDialog(null, "", "About", JOptionPane.INFORMATION_MESSAGE, icon);
       
       //List<DisplayAnswer> col = new LinkedList();
       
       //col = b.getAnswers(1);
        
       //System.out.println(col.size());
       
      /* if(col == null){
           System.out.println("collection size null");
       }
       else{
       for(DisplayAnswer answer: col){
            System.out.print(answer.toString());
       }
       
         
       }*/
       
    }
    
}

