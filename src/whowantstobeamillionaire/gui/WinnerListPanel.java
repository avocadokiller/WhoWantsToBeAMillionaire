/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whowantstobeamillionaire.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class WinnerListPanel extends JPanel{
      
    JButton backToMain1;
    DefaultTableModel winTableModel;
    JTable winTable;
    Image bgImage;   
    Font customFont, customFont2;
    
    public WinnerListPanel() throws FontFormatException{
          
       
         
        backToMain1 = new JButton("BACK TO MAIN");
        winTableModel = new DefaultTableModel();
        
        try{
            bgImage = ImageIO.read(new File("questionbg.png"));
        } catch(Exception e){
            e.printStackTrace();
        }
        try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("powerpuff girls font.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }    

        try {
    
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }  

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "WINNERS LIST", TitledBorder.CENTER, TitledBorder.TOP, customFont, new Color(168, 221, 255)));
       
        winTableModel.addColumn("Name");       
        winTableModel.addColumn("Date");
        winTable = new JTable(winTableModel); 
        backToMain1.setBounds(125, 500, 130, 30);
        backToMain1.setBackground(new Color(15, 60, 139));
        backToMain1.setForeground(new Color(168, 221, 255));
       
        winTable.setBackground(new Color(168, 221, 255));
        winTable.getTableHeader().setBackground(new Color(15, 60, 139));
        winTable.getTableHeader().setForeground(new Color(168, 221, 255));
        winTable.setPreferredScrollableViewportSize(new Dimension(350,400));
        winTable.getTableHeader().setFont(customFont2);
        winTable.setFont(customFont2);
        winTable.setPreferredSize(new Dimension(350, 400));
        winTable.enableInputMethods(false);
        backToMain1.setFont(customFont2);

        this.add(new JScrollPane(winTable), BorderLayout.CENTER);
        this.add(backToMain1);
}
      @Override
        protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
}
