/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mmohamud
 */
public class StatisticsTest {
    
        Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void searchTest() {
        Player selanne = stats.search("selanne");
        assertEquals(null, selanne);
        
        Player kurri = stats.search("Kurri");
        assertEquals("Kurri", kurri.getName());
    }
    
    @Test 
    public void teamSearchTest() {
        List team = stats.team("EDM");
        assertEquals(3, team.size());      
    }
    
    @Test
    public void topScorersTest() {
        List top3Scorers = stats.topScorers(2);
        assertEquals(3, top3Scorers.size());
    }
}
