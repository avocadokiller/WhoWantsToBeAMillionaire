
package whowantstobeamillionaire.gui;

import java.io.IOException;
import java.awt.FontFormatException;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 *
 * @author Sasha Buskin
 */
public class MVC {//MVC class to hold with main function bringing together model, view and controller objects.
    
    public static void main(String[] args) throws IOException, FontFormatException, SQLException {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        WhoWantsToBeAMillionaire game = new WhoWantsToBeAMillionaire();      
        View view = new View();
        Controller z = new Controller(view, game);
        
       
        
    }
}
