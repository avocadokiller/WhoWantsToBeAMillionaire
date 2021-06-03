
package whowantstobeamillionaire.gui;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sasha Buskin
 */
public class WhoWantsToBeAMillionaireTest {
    
    public WhoWantsToBeAMillionaireTest() {
    }
   
    /**
     * Test of UpdateQuestion method, of class WhoWantsToBeAMillionaire.
     */
    @Test
    public void testUpdateQuestion() {
        System.out.println("UpdateQuestion");
        WhoWantsToBeAMillionaire instance = new WhoWantsToBeAMillionaire();
        instance.UpdateQuestion();     
        assertEquals(1, instance.q.level);
        instance.lvl = 10;
        instance.UpdateQuestion();        
        assertEquals(10, instance.q.level);
      
    }

    /**
     * Test of addWinnings method, of class WhoWantsToBeAMillionaire.
     */
    @Test
    public void testAddWinnings() {
        System.out.println("addWinnings");
        WhoWantsToBeAMillionaire instance = new WhoWantsToBeAMillionaire();
        instance.a = new Contestant("jim");
        instance.addWinnings();
        Integer target = new Integer(100);
        assertEquals(target, instance.a.money);
        instance.addWinnings();
        instance.a.money = 64000;
        instance.addWinnings();
        target = 125000;
        assertEquals(target, instance.a.money);
    }

}
