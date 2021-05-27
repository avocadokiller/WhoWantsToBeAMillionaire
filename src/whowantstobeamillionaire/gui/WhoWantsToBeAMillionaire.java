/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import whowantstobeamillionaire.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sasha Buskin
 */  
public class WhoWantsToBeAMillionaire {
  
    Contestant a =  new Contestant(" ");    
    GameDB gameDB = new GameDB();
    Integer lvl = Integer.valueOf(1);
    Question q = new Question();
    
                                                       
    public void UpdateQuestion(){
    
        if(this.lvl <= 15){
        this.q = randomQuestion();
        }
        
        
    }

public void addWinnings(){
        if(this.a.money == 0){
            this.a.money += 100;
        }
        else if(this.a.money == 200){
            this.a.money += 100;
        }
        else if(this.a.money == 300){
            this.a.money += 200;
        }
        else if(this.a.money == 64000){
            this.a.money += 61000;
        }
        else if(this.a.money == 1000000){
            
        }
        else{
            this.a.money *=  2;
        }
    }

public Question randomQuestion(){
                       
        Question q = new Question();
        List<Question> a = new ArrayList();
        
        try {
            a = gameDB.getQuestionSet(this.lvl);
        
        } catch (SQLException ex) {
            Logger.getLogger(WhoWantsToBeAMillionaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, a.size());
               
        q = a.get(randomNum);       
                
        return q;
    } 
}
  
