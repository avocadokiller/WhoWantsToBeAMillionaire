
package whowantstobeamillionaire.gui;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sasha Buskin
 */
public class DBManagerTest {
    
    public DBManagerTest(){
        
    }
  
    /**
     * Test of getConnection method, of class DBManager.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DBManager instance = new DBManager();
        instance.establishConnection();
        Connection result = instance.getConnection();
        System.out.println(result.toString());
        assertEquals("org.apache.derby.client.net.NetConnection@43a25848", result.toString());
       
    }

    /**
     * Test of establishConnection method, of class DBManager.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");
        DBManager instance = new DBManager();
        instance.establishConnection();
        Connection result = instance.getConnection();
        System.out.println(result.toString());
        assertEquals("org.apache.derby.client.net.NetConnection@43a25848", result.toString());
      
    }

    
    
}
