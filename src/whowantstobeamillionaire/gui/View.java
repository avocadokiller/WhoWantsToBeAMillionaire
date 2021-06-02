/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.awt.CardLayout;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Sasha Buskin
 */
public class View extends JFrame {//View of the MVC, combining all Jpanel classes with cardlayout layout manager. 

    CardLayout cl;

    JPanel panelCont;  
    MenuPanel menuCard;
    EnterNamePanel namePanel;
    QuestionPanel questionPanel;
    GameOverPanel gameOverPanel;
    GameHistoryPanel gameHistoryPanel;
    WinnerListPanel winnerListPanel;
    YouWinPanel youWinPanel;
    
    public View() throws FontFormatException {

        this.cl = new CardLayout();
        this.panelCont = new JPanel();
        this.panelCont.setLayout(cl);
       
        youWinPanel = new YouWinPanel();//youWinCard  
        namePanel = new EnterNamePanel();//enterNameCard
        winnerListPanel = new WinnerListPanel();//WinnerListPanel
        gameHistoryPanel = new GameHistoryPanel();//GameRecordCard
        menuCard = new MenuPanel();//Menu card
        questionPanel = new QuestionPanel();// Question card
        gameOverPanel = new GameOverPanel();//Gameover card

        //Adding all the cards to main panel with card layout
        panelCont.add(youWinPanel, "7");
        panelCont.add(namePanel, "6");
        panelCont.add(menuCard, "1");
        panelCont.add(questionPanel, "2");
        panelCont.add(gameOverPanel, "3");
        panelCont.add(gameHistoryPanel, "4");
        panelCont.add(winnerListPanel, "5");

        
        setLocationByPlatform(true);
        this.setVisible(true);
        this.setSize(400, 600);
        this.add(panelCont);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Show Menu card first
        cl.show(panelCont, "1");
         
    }
//Method to add actionlistener to all menubuttons in the gui.    
void addReturnButtonListener(ActionListener listenForButton) { 
       
    gameOverPanel.backToMain.addActionListener(listenForButton);
    gameHistoryPanel.newbut.addActionListener(listenForButton);
    winnerListPanel.backToMain1.addActionListener(listenForButton);
    youWinPanel.backToMain2.addActionListener(listenForButton);
    
}
   
}
