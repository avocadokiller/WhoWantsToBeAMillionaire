
package whowantstobeamillionaire.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Sasha Buskin 19093824
 */
public class Controller {//Controller to control interactions between model and view
    private View view; 
    private WhoWantsToBeAMillionaire model;
    
    public Controller(View view, WhoWantsToBeAMillionaire model){
        
        this.view = view;
        this.model = model;
 
        model.q = model.randomQuestion();
        updateQuestionGui();
        
        //Add all actionlisteners to the view components when controller instantiated
        view.questionPanel.addQButtonListener(new AnswerListener1());
        view.menuCard.addMButtonListener(new AnswerListener2());
        view.addReturnButtonListener(new AnswerListener3());
        view.namePanel.addNameTextListener(new AnswerListener5());
        view.questionPanel.timer.addActionListener(new AnswerListener6());
    }
    
    //Method to update the game question panel
    void updateQuestionGui(){
       
        view.questionPanel.updateTimer();
        view.questionPanel.timer.restart();
        
        String[] answers = new String[]{model.q.correct, model.q.wrong1, model.q.wrong2, model.q.wrong3};
        ArrayList<String> shuffledAnswers = new ArrayList<>(Arrays.asList(answers));
        Collections.shuffle(shuffledAnswers);
       
        view.questionPanel.questionArea.setText(model.q.question);
        view.questionPanel.a.setText("A. "+shuffledAnswers.get(0));
        view.questionPanel.b.setText("B. "+shuffledAnswers.get(1));
        view.questionPanel.c.setText("C. "+shuffledAnswers.get(2));
        view.questionPanel.d.setText("D. "+shuffledAnswers.get(3));
        view.questionPanel.qNum.setText("Question "+model.lvl.toString()+".");
        view.questionPanel.winnings.setText("$"+model.a.money.toString());
   
    }
    
    //Answerlistener to control how program reacts to input into the game question panel, updates question gui, database
    class AnswerListener1 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(view.questionPanel.a)){//If A is clicked 
                
                if(view.questionPanel.a.getText().contains(model.q.correct)){//If A is correct
              
                     model.addWinnings();
                    
                    if(model.a.money != 1000000){
                        model.lvl++;
                        model.UpdateQuestion();
                        updateQuestionGui();
                    }

                }
                else{//If A is incorrect
                    
                    view.gameOverPanel.winnings.append(model.a.money.toString());
                    view.cl.show(view.panelCont, "3");
                    model.lvl = 1;
                    try {
                            model.gameDB.addContestantToDB(model.a);
                                          
                    }   catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                    updateQuestionGui();
                 }
            } 
                
            else if(e.getSource().equals(view.questionPanel.b)){//If B is clicked 
               
                if(view.questionPanel.b.getText().contains(model.q.correct)){//If B is correct
                   
                    model.addWinnings();
                   
                    if(model.a.money != 1000000){
                    model.lvl++;
                    model.UpdateQuestion();
                       
                    updateQuestionGui();
                    }
                }
                else{//If B is incorrect
                      
                      view.gameOverPanel.winnings.append(model.a.money.toString());
                      view.cl.show(view.panelCont, "3"); 
                      
                      model.lvl = 1;
                      try {
                            model.gameDB.addContestantToDB(model.a);
                                          
                    }   catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                       updateQuestionGui();
                }
            }    
            else if(e.getSource().equals(view.questionPanel.c)){//If C is clicked 
                
                if(view.questionPanel.c.getText().contains(model.q.correct)){//If C is correct
                   
                    model.addWinnings();
                    
                    if(model.a.money != 1000000){
                        
                        model.lvl++;
                        model.UpdateQuestion();
                        
                        updateQuestionGui();
                    }
                }
                else{//If C is incorrect
                      
                      view.gameOverPanel.winnings.append(model.a.money.toString());
                      view.cl.show(view.panelCont, "3");
                       model.lvl = 1;
                       try {
                            model.gameDB.addContestantToDB(model.a);
                                          
                    }   catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                       updateQuestionGui();
                }
            }
            else if(e.getSource().equals(view.questionPanel.d)){//If D is clicked 
               
                if(view.questionPanel.d.getText().contains(model.q.correct)){//If D is correct

                    model.addWinnings();
                    if(model.a.money != 1000000){
                        model.lvl++;
                        model.UpdateQuestion();
                        updateQuestionGui();
                    }
                }
                else{//If D is incorrect
                    
                   
                    try {
                            model.gameDB.addContestantToDB(model.a);
                                          
                    }   catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                    view.gameOverPanel.winnings.append(model.a.money.toString());
                    view.cl.show(view.panelCont, "3"); 
                    model.lvl = 1;
                }
            }
         
            if(model.a.money == 1000000){//If user wins
              
                view.cl.show(view.panelCont, "7"); 
                model.lvl = 1;
                try {
                            model.gameDB.addContestantToDB(model.a);
                                          
                    }   catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                
                model.UpdateQuestion();
                updateQuestionGui();
            }
  
        }
    }
   
    //Actionlistener class to control the menu buttons and transition between cards in card layout
    class AnswerListener2 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(view.menuCard.play)){//If user selects play
                
               view.cl.show(view.panelCont, "6"); 
                view.questionPanel.updateTimer();
                view.questionPanel.timer.stop();
            }
            else if(e.getSource().equals(view.menuCard.gList)){//If user selects game history
                
                clearGamesTable();
                buildGamesTable();    
                view.cl.show(view.panelCont, "4"); 
               
            }
            else if(e.getSource().equals(view.menuCard.wList)){//If user selects winner list
                clearWinTable();
                buildWinTable(); 
               view.cl.show(view.panelCont, "5"); 
            }
        }
        
    }
    
    //Back to main actionlistener for game over button
    class AnswerListener3 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.panelCont, "1"); 
            view.gameOverPanel.winnings.setText("You finished with: $");
        }
        
    }
    
    class AnswerListener4 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.panelCont, "4"); 
        }
        
    }
    //Method to clear game history table     
    public void clearGamesTable(){
         view.gameHistoryPanel.gameTableModel.setRowCount(0);
     }
    //Method to build game history table using db retrieval methods  
    public void buildGamesTable(){
     
        List<Contestant> contestants = new ArrayList<>();
        try {
            contestants = model.gameDB.getContestantList();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Collections.reverse(contestants);

        for (Contestant contestant : contestants) {
            view.gameHistoryPanel.gameTableModel.addRow(new Object[]{contestant.name, contestant.money, contestant.date});
        }
    
    }
    //Method to clear winner list  
    public void clearWinTable(){
        view.winnerListPanel.winTableModel.setRowCount(0);
    }
    //Method to build winner list using db retrieval methods
    public void buildWinTable(){
        List<Contestant> contestants = new ArrayList<>();
        try {
            contestants = model.gameDB.getContestantList();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        for (Contestant contestant : contestants) {
        
            if(contestant.money == 1000000){
            view.winnerListPanel.winTableModel.addRow(new Object[]{contestant.name, contestant.date});
            }
        }
    }
     
    //Actionlistener to recieve name from name entry panel and contruct new contestant accordingly, then change panel to begin game
    class AnswerListener5 implements ActionListener{ 

        public void actionPerformed(ActionEvent e) {
            view.questionPanel.updateTimer();
            Contestant g = new Contestant(view.namePanel.name.getText());
            model.a = g;
            view.cl.show(view.panelCont, "2"); 
            view.namePanel.name.setText(" ");
            updateQuestionGui();
            
            view.questionPanel.nameLabel.setText("Contestant: "+model.a.name);
        }
    }
     
    //Actionlistener added to timer to react when timer reaches 0 (user added to db, view game over panel)
    class AnswerListener6 implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            if(view.questionPanel.time == 0){
                try {
                         model.gameDB.addContestantToDB(model.a);

                }   catch (SQLException ex) {
                     Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }  
                
                view.gameOverPanel.winnings.append(model.a.money.toString());
                view.cl.show(view.panelCont, "3"); 
                model.lvl = 1;
                view.questionPanel.timer.stop();
            }
              
        } 
    }
}
        
    
