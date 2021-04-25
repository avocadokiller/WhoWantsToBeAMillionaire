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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class QuestionPanel extends JPanel{
        
        JTextArea questionArea; 
        JTextField qNum, winnings;
        JButton a, b, c, d;
        JLabel nameLabel;
        Image bgImage;
        Font customFont;
    public QuestionPanel() throws FontFormatException{
              
         try{
    bgImage = ImageIO.read(new File("questionbg.png"));
} catch(Exception e){e.printStackTrace();}
        
         
         try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }   
         nameLabel = new JLabel();
        this.questionArea = new JTextArea();
        this.qNum = new JTextField();
        this.winnings = new JTextField();
        this.questionArea.setBackground(new Color(47, 59, 64));
        this.qNum.setBackground(new Color(47, 59, 64));
        this.winnings.setBackground(new Color(47, 59, 64));
        this.questionArea.setForeground(new Color(168, 221, 255));
        this.qNum.setForeground(new Color(168, 221, 255));
        this.winnings.setForeground(new Color(255,165,0));
        this.questionArea.setEditable(false);
        this.qNum.setEditable(false);
        this.winnings.setEditable(false);
        this.winnings.setBorder(BorderFactory.createLoweredBevelBorder()); 
        this.winnings.setFont(customFont);
        this.qNum.setBorder(BorderFactory.createLoweredBevelBorder());
        this.qNum.setFont(customFont);
        this.questionArea.setBorder(BorderFactory.createLoweredBevelBorder());
        this.questionArea.setWrapStyleWord(true);
        this.questionArea.setFont(customFont);
        this.nameLabel.setForeground(new Color(255,165,0));
        this.nameLabel.setFont(customFont);
       
        this.a = new JButton("A");
        this.b = new JButton("B");
        this.c = new JButton("C");
        this.d = new JButton("D");
        this.a.setBackground(new Color(15, 60, 139));
        this.b.setBackground(new Color(15, 60, 139));
        this.c.setBackground(new Color(15, 60, 139));
        this.d.setBackground(new Color(15, 60, 139));
        this.a.setForeground(new Color(168, 221, 255));
        this.b.setForeground(new Color(168, 221, 255));
        this.c.setForeground(new Color(168, 221, 255));
        this.d.setForeground(new Color(168, 221, 255));
        this.a.setFont(customFont);
        this.b.setFont(customFont);
        this.c.setFont(customFont);
        this.d.setFont(customFont);
        
        
        this.setLayout(null);
        nameLabel.setBounds(0, 0, 250, 20);

        qNum.setEditable(false);
        qNum.setBounds(140, 80, 120, 20);
        questionArea.setEditable(false);       
        questionArea.setBounds(75, 100, 250, 100);
        questionArea.setLineWrap(true);
        winnings.setEditable(false);
        winnings.setBounds(310, 0, 90, 20);
        a.setBounds(70, 300, 250, 30);
        b.setBounds(70, 350, 250, 30);
        c.setBounds(70, 400, 250, 30);
        d.setBounds(70, 450, 250, 30);

        this.add(nameLabel);
        this.add(winnings);
        this.add(questionArea);
        this.add(qNum);
        this.add(a);
        this.add(b);
        this.add(c);
        this.add(d);
}
     
    protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
    
    void addQButtonListener(ActionListener listenForButton) {

        a.addActionListener(listenForButton);
        b.addActionListener(listenForButton);
        c.addActionListener(listenForButton);
        d.addActionListener(listenForButton);
    }
}
