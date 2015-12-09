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
public abstract class GenericAnswer{
    
     
    private int answerID;
    private String datePosted;
    private String TNumber;
    private int likes;
    private int questionID;
    
    public GenericAnswer(){
    }
    
    public GenericAnswer(int answerID, String datePosted, String TNumber, int likes, int questionID) {
        this.answerID = answerID;
        this.datePosted = datePosted;
        this.TNumber = TNumber;
        this.likes = likes;
        this.questionID = questionID;
    }

    public int getAnswerID() {
        return answerID;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public String getTNumber() {
        return TNumber;
    }

    public int getLikes() {
        return likes;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "\nAnswer ID:" + answerID + 
               "\nDate Posted:" + datePosted + 
               "\nTNumber:" + TNumber + 
               "\nLikes:" + likes + 
               "\nQuestion ID:" + questionID;
    }
    
    
   
}
