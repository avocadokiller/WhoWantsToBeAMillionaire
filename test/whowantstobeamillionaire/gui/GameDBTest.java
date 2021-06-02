
package whowantstobeamillionaire.gui;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sasha Buskin
 */
public class GameDBTest {
    
    public GameDBTest(){
        
    }
   
 /**
     * Test of addContestantToDB method, of class GameDB.
     */
    @Test
    public void testAddContestantToDB() throws Exception {
        System.out.println("addContestantToDB");
        Contestant contestant = new Contestant("Samuel");
        GameDB instance = new GameDB();
        instance.addContestantToDB(contestant);
        List<Contestant> contestantList = new ArrayList(); 
        contestantList = instance.getContestantList();
        Contestant contestant2 = contestantList.get(contestantList.size()-1);
        assertEquals(contestant.name, contestant2.name);
        assertEquals(contestant.date, contestant2.date);
     
    }

    /**
     * Test of getQuestionSet method, of class GameDB.
     */
    @Test
    public void testGetQuestionSet() throws Exception {
        System.out.println("getQuestionSet");
        int lvl = 10;
        GameDB instance = new GameDB();        
        List<Question> result = instance.getQuestionSet(lvl);
        int sum = (result.get(0).level * result.size());
        assertEquals(100, sum);
        lvl = 6;
        result = instance.getQuestionSet(lvl);
        sum = (result.get(0).level * result.size());
        assertEquals(60, sum);
        }
    

}
