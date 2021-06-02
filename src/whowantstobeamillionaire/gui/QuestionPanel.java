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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Sasha Buskin
 */
public class QuestionPanel extends JPanel {//Panel to facilitate asking game question
        
        JTextArea questionArea; 
        JTextField qNum, winnings;
        JButton a, b, c, d;
        JLabel nameLabel;
        Image bgImage;
        Font customFont, customFont2;
        JProgressBar timeBar;//countdown timer
        Integer time;
        JTextArea timeLabel;
        Timer timer;
        
    public QuestionPanel() throws FontFormatException{
         //Load image background     
        try{
          bgImage = ImageIO.read(new File("questionbg.png"));
        } catch(Exception e){e.printStackTrace();}
        //Load custom font
        try {
    
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("powerpuff girls font.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont2);
            } catch (IOException e) {
                e.printStackTrace();
            }     
        //Implement panel border with header
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "WhoWantsToBeAMillionaire", TitledBorder.CENTER, TitledBorder.TOP, customFont2, new Color(168, 221, 255)));
        //Load custom font 
        try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }   
        
        nameLabel = new JLabel();
        this.timeBar = new JProgressBar();
      
        this.questionArea = new JTextArea();
        this.qNum = new JTextField();
        this.winnings = new JTextField();
        this.time =  30;
        this.timeLabel = new JTextArea(" "+time.toString());
        
        //Label displaying time to change with time bar
        this.timeLabel.setBounds(163, 500, 66, 40);
        this.timeLabel.setFont(customFont2);
        this.timeLabel.setFont(this.timeLabel.getFont().deriveFont(19f));
        this.timeLabel.setBackground(new Color(47, 59, 64));
        this.timeLabel.setForeground(new Color(168, 221, 255));
       
        //Setting up time bar for question countdown
        this.timeBar.setValue(30);
        this.timeBar.setMaximum(30);
        this.timeBar.setString(" ");        
        this.timeBar.setBounds(0, 552, 400, 15);
        this.timeBar.setStringPainted(true);
        this.timeBar.setBackground(new Color(168, 221, 255));
        this.timeBar.setForeground(new Color(15, 60, 139));
        this.timeBar.setFont(customFont);
        
        //Area to display question
        this.questionArea.setBackground(new Color(47, 59, 64));
        this.questionArea.setForeground(new Color(168, 221, 255));
        this.questionArea.setEditable(false);  
        this.questionArea.setBorder(BorderFactory.createLoweredBevelBorder());
        this.questionArea.setWrapStyleWord(true);
        this.questionArea.setFont(customFont);
        this.questionArea.setEditable(false);       
        this.questionArea.setBounds(75, 100, 250, 100);
        this.questionArea.setLineWrap(true);
        
        // To display question number
        this.qNum.setBackground(new Color(47, 59, 64));
        this.qNum.setForeground(new Color(168, 221, 255));
        this.qNum.setEditable(false); 
        this.qNum.setFont(customFont);
        this.qNum.setBorder(BorderFactory.createLoweredBevelBorder());
        this.qNum.setEditable(false);
        this.qNum.setBounds(140, 80, 120, 20);
        
        //To display current money
        this.winnings.setBackground(new Color(47, 59, 64));
        this.winnings.setForeground(new Color(255,165,0));              
        this.winnings.setEditable(false);
        this.winnings.setBorder(BorderFactory.createLoweredBevelBorder()); 
        this.winnings.setFont(customFont);
        this.winnings.setEditable(false);
        this.winnings.setBounds(285, 25, 90, 20);
        
        //To display current contestant
        this.nameLabel.setForeground(new Color(255,165,0));
        this.nameLabel.setFont(customFont);
        this.nameLabel.setBounds(25, 25, 250, 20);
        
        //Answer buttons
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
    
        this.a.setBounds(70, 300, 250, 30);
        this.b.setBounds(70, 350, 250, 30);
        this.c.setBounds(70, 400, 250, 30);
        this.d.setBounds(70, 450, 250, 30);
        
        this.setLayout(null);

        this.add(nameLabel);
        this.add(winnings);
        this.add(questionArea);
        this.add(qNum);
        this.add(a);
        this.add(b);
        this.add(c);
        this.add(d);
        this.add(timeBar);
        this.add(timeLabel);
        simpleTimer();

    }
    //Method to paint backgound with imported image 
    protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
    //Method to add an actionlistener to each answer button
    void addQButtonListener(ActionListener listenForButton) {

        a.addActionListener(listenForButton);
        b.addActionListener(listenForButton);
        c.addActionListener(listenForButton);
        d.addActionListener(listenForButton);
    }        

   
    //Method to instantiate and control the timer and its actionlistener
    public void simpleTimer(){
   
      timer = new Timer(1000,new ActionListener(){
          
          @Override
          public void actionPerformed(ActionEvent e){
              
              if(time>0){
                  time--;
              }
              if(time<11){
                  timeLabel.setForeground(Color.red);
                  timeBar.setForeground(Color.red);
              }
              else{
                  timeLabel.setForeground(new Color(168, 221, 255));
                  timeBar.setForeground(new Color(15, 60, 139));
              }
            
              timeLabel.setText(" "+time.toString());
              timeBar.setValue(time);
          }
          
          
      });
   }
   //Method to restart timer
    public void updateTimer(){
        time = 31;
    }

   
}
