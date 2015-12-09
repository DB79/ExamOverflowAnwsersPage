/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.util.Date;

/**
 *
 * @author Damien
 */
public class DisplayAnswer {

    @Override
    public String toString() {
        return "\nAnswerText: " + answerText + "\nLikes: " + likes + "\nUsername: " + username + 
               "\nDatePosted: " + datePosted + "\nAnswer ID: " + answerID;
    }
    private int answerID;
    private String answerText;
    private int likes;
    private String username;
    private Date datePosted;
    private byte[] profileImage;
    
    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }
    
    public DisplayAnswer(){
    }

    public DisplayAnswer(int answerID, String answerText, byte[] profileImage, 
                         int likes, String username, Date datePosted) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.likes = likes;
        this.username = username;
        this.datePosted = datePosted;
        this.profileImage = profileImage;
    }
    
    public String getAnswerText() {
        return answerText;
    }

    public int getLikes() {
        return likes;
    }

    public String getUsername() {
        return username;
    }
    
    public Date getDatePosted(){
        return datePosted;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setDatePosted(Date datePosted){
        this.datePosted = datePosted;
    }
    
    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }
    
}
