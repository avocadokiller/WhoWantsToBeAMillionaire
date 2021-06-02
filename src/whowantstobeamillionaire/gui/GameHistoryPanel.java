
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
 * @author Sasha Buskin
 */
public class GameHistoryPanel extends JPanel{//Panel to display limited length game history details in a JTable
    
    JButton newbut;
    DefaultTableModel gameTableModel;
    JTable table;
    Image bgImage;
    Font customFont, customFont2;
    
    public GameHistoryPanel() throws FontFormatException{
         
        //Import background image
        try{
        bgImage = ImageIO.read(new File("questionbg.png"));
        } catch(Exception e){e.printStackTrace();}
        
        //Import custom font    
        try {
    
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("powerpuff girls font.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }    
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "GAME HISTORY", TitledBorder.CENTER, TitledBorder.TOP, customFont, new Color(168, 221, 255)));
        //Import custom font  
        try {
    
            customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            }  
       
        //Set up back to main button
        newbut = new JButton("BACK TO MAIN");
        newbut.setBounds(125, 500, 130, 30);
        newbut.setBackground(new Color(15, 60, 139));
        newbut.setForeground(new Color(168, 221, 255));
        newbut.setFont(customFont2);
        
        //Set up model for the game history Jtable
        gameTableModel = new DefaultTableModel();
        gameTableModel.addColumn("NAME");
        gameTableModel.addColumn("WINNINGS");
        gameTableModel.addColumn("DATE");
        
        //Set up JTable for game history
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
    //Method to paint background with image
    protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
}
