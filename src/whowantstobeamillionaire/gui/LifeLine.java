/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import whowantstobeamillionaire.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LifeLine {
    
    
    
    public void fiftyFifty(ArrayList c,Question a, Contestant b){
        
            
        String[] wrongAnswers = new String[]{a.wrong1, a.wrong2, a.wrong3};
        ArrayList shuffleWrong = new ArrayList<>(Arrays.asList(wrongAnswers));
        Collections.shuffle(shuffleWrong);
        int storeWrong = 0;
        int looper = 0;
        while(storeWrong != 2)
        {
            if(!c.get(looper).equals(a.correct))
            {
                c.set(looper, " ");
                storeWrong++;
            }
            looper++;
        }

        String Table = "| %-50s| %-50s |%n";
        String QuestionFormat = "|  %-102s|%n";
        String QuestionNumberFormat = "|                                               %-57s|%n";              
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
                        System.out.format(QuestionNumberFormat,"Question "+a.level);
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");
                        System.out.format(QuestionFormat,a.question);
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");

                        System.out.format(Table,"a. "+ c.get(0), "b. "+ c.get(1));
                        System.out.format(Table,"c. "+ c.get(2), "d. "+ c.get(3));
                        System.out.format("+--------------------------------------------------------------------------------------------------------+%n");

                        b.fiftyFifty = 0;
    }
    
    public void Hint(Question a, Contestant b){
        System.out.println("Hint: "+a.hint);
        b.hint = 0;
    }
  }
