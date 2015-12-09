/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

/**
 *
 * @author Damien
 */
public class Dislike {
    
    private String TNumber;
    private int answerID;
    
    public Dislike(String TNumber, int answerID) {
        this.TNumber = TNumber;
        this.answerID = answerID;
    }
    public Dislike(){
        
    }
    
    public String getTNumber() {
        return TNumber;
    }

    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }
    
    
    
    
}
