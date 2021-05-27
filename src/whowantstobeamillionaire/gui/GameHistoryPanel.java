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
public class GameHistoryPanel extends JPanel{
    
    JButton newbut;
    DefaultTableModel gameTableModel;
    JTable table;
    Image bgImage;
    Font customFont, customFont2;
    
    public GameHistoryPanel() throws FontFormatException{
          
        try{
        bgImage = ImageIO.read(new File("questionbg.png"));
        } catch(Exception e){e.printStackTrace();}
        
        newbut = new JButton("BACK TO MAIN");
        newbut.setBounds(125, 500, 130, 30);
        newbut.setBackground(new Color(15, 60, 139));
        newbut.setForeground(new Color(168, 221, 255));
        try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("powerpuff girls font.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }    
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "GAME HISTORY", TitledBorder.CENTER, TitledBorder.TOP, customFont, new Color(168, 221, 255)));
         try {
    
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }  
        
        newbut.setFont(customFont2);
        
        gameTableModel = new DefaultTableModel();
        gameTableModel.addColumn("NAME");
        gameTableModel.addColumn("WINNINGS");
        gameTableModel.addColumn("DATE");
        
        
        table = new JTable(gameTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(350,400));
        table.setBackground(new Color(168, 221, 255));
        table.getTableHeader().setBackground(new Color(15, 60, 139));
        table.getTableHeader().setForeground(new Color(168, 221, 255));
        table.setPreferredSize(new Dimension(350, 400));
        table.enableInputMethods(false);
        table.setFont(customFont2);
        table.getTableHeader().setFont(customFont2);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(newbut);
    }
    
    protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
}
