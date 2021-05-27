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
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class EnterNamePanel extends JPanel{
    
    JTextField name;
    Image bgImage;
    Font customFont;
    
    public EnterNamePanel() throws FontFormatException{
        
        try{
        bgImage = ImageIO.read(new File("enternamebg.png"));
        } catch(Exception e){e.printStackTrace();}
        
        try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            } 
        
        this.name = new JTextField();
        
        this.name.setFont(customFont);
        this.name.setBackground(new Color(47, 59, 64));
        this.name.setForeground(new Color(168, 221, 255));
        this.name.setCaretColor(new Color(168, 221, 255));
        this.name.setBorder(BorderFactory.createLoweredBevelBorder()); 
        this.name.setBounds(140, 370, 120, 30);
        
        this.setLayout(null);
        this.add(name);
    }
     
    @Override
    protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
    
    void addNameTextListener(ActionListener listenForButton) {
        name.addActionListener(listenForButton);
    }
}
