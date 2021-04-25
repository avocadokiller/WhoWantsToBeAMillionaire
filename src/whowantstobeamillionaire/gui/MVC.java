/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.io.IOException;
import java.awt.FontFormatException;
import javax.swing.JFrame;
/**
 *
 * @author Admin
 */
public class MVC {
    public static void main(String[] args) throws IOException, FontFormatException {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        WhoWantsToBeAMillionaire game = new WhoWantsToBeAMillionaire();
        game.fc.newQuestionFiles();
        game.fc.writeQuestionFiles(); 
        View view = new View();
        Controller z = new Controller(view, game);
       


    }
}
