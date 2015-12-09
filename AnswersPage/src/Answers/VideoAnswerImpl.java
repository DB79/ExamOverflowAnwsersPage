/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answers;

import java.io.File;

/**
 *
 * @author Damien
 */
public class VideoAnswerImpl extends GenericAnswer{

    private File video;
    
    public VideoAnswerImpl(){
        
    }

    public VideoAnswerImpl(int answerID, File video, String datePosted,String TNumber, int likes, int questionID){
        super(answerID,datePosted,TNumber,likes,questionID);
        this.video = video;
    }
    
    public File getVideo() {
        return this.video;
    }
    
    public void setVideo(File video) {
        this.video = video;
    }
    
    
    
    
}
