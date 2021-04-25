/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class MenuPanel extends JPanel{
    
    JButton  play, wList, gList;
    Image bgImage;
    Font customFont;
    public MenuPanel() throws FontFormatException{
      
        try{
    bgImage = ImageIO.read(new File("Untitled.png"));
} catch(Exception e){e.printStackTrace();}
       
        
         try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }  
        this.play = new JButton("PLAY");
        this.wList = new JButton("WINNER LIST");
        this.gList = new JButton("GAME HISTORY");
        this.play.setBackground(new Color(15, 60, 139));
        this.wList.setBackground(new Color(15, 60, 139));
        this.gList.setBackground(new Color(15, 60, 139));
        this.play.setForeground(new Color(168, 221, 255));
        this.wList.setForeground(new Color(168, 221, 255));
        this.gList.setForeground(new Color(168, 221, 255));
        this.play.setFont(customFont);
        this.wList.setFont(customFont);
        this.gList.setFont(customFont);
        
        this.setLayout(null);
        play.setBounds(70, 350, 250, 30);
        wList.setBounds(70, 400, 250, 30);
        gList.setBounds(70, 450, 250, 30);

        this.add(wList);
        this.add(gList);
        this.add(play);
}
    @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
  void addMButtonListener(ActionListener listenForButton) {
       
        play.addActionListener(listenForButton);
        wList.addActionListener(listenForButton);
        gList.addActionListener(listenForButton);

    }
}