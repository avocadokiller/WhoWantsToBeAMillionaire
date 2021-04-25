/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import whowantstobeamillionaire.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class Question implements Serializable{
    
    
    String question;
    int level;
    String wrong1, wrong2, wrong3, correct;
   // String[] answers = new String[]{correct, wrong1, wrong2, wrong3};
   // ArrayList<String> shuffledAnswers = new ArrayList<>(Arrays.asList(answers));
    String hint;
    
    
     public Question(String question, int level, String wrong1, String wrong2, String wrong3, String correct, String hint) {
        
        this.question = question;
        this.level = level;
        this.wrong1 = wrong1;
        this.wrong2 = wrong2;
        this.wrong3 = wrong3;
        this.correct = correct;
        this.hint = hint;
      //  Collections.shuffle(shuffledAnswers);
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", level=" + level + ", wrong1=" + wrong1 + ", wrong2=" + wrong2 + ", wrong3=" + wrong3 + ", correct=" + correct + ", hint=" + hint + '}';
    }
    
    
    
    
}
