/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.sql.Blob;

/**
 *
 * @author Damien
 */
public class TextAnswerImpl extends GenericAnswer{

    private String answerText;

    
    public TextAnswerImpl(){
        
    }
    
    public TextAnswerImpl(int answerID, String answerText, String datePosted,String TNumber, int likes, int questionID) {
        
        super(answerID,datePosted,TNumber,likes,questionID);
        this.answerText = answerText;
    }
    
   
    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return  "Answer:" + answerText + super.toString();
    }

    
   
}