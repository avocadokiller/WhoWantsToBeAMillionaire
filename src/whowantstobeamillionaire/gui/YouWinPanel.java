
package whowantstobeamillionaire.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sasha Buskin 
 */
public class YouWinPanel extends JPanel{ //JPanel class to be displayed only if contestant reaches one million
    
    JButton backToMain2;
    Image bgImage;  
    Font customFont;
    
    public YouWinPanel() throws FontFormatException{
    //Load custom font for Jbutton
    try {
    
        customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Commodore Rounded v1.2.ttf")).deriveFont(12f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        ge.registerFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    //Load background image
    try {
         bgImage = ImageIO.read(new File("youwinbg.png"));
        } catch(Exception e){
            e.printStackTrace();
        }
       
       
        backToMain2 = new JButton("BACK TO MAIN");
        backToMain2.setBounds(125, 500, 150, 30);
        backToMain2.setFont(customFont);
        backToMain2.setBackground(new Color(15, 60, 139));
        backToMain2.setForeground(new Color(168, 221, 255));
        
        this.setLayout(null);
        this.add(backToMain2);

}
//To paint backgroung with imported image    
protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
}
}