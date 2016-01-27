
package fi.joonassa.impossiblegameproject.actors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Player player;
    
    public PlayerTest() {
    }

    @Before
    public void setUp() {
        player = new Player(0, 0);
    }
    
    //get & set-testit ovat tällä hetkellä hiukan turhia, mutta tulevaisuudessa 
    //niillä varmistetaan etteivät Actorit pääse ulos pelialueelta
    @Test
    public void playerGetXTest() {
        assertEquals(0, player.getX());
    }
    
    @Test
    public void playerGetYTest() {
        assertEquals(0, player.getY());
    }
    
    @Test
    public void playerSetXTest() {
        player.setX(5);
        assertEquals(5, player.getX());
    }
    
    @Test
    public void playerSetYTest() {
        player.setY(5);
        assertEquals(5, player.getY());
    }

    @Test 
    public void playerSetNegativeXTest() {
        player.setX(-5);
        assertEquals(0, player.getX());
    }
    
    @Test 
    public void playerSetNegativeYTest() {
        player.setY(-5);
        assertEquals(0, player.getY());
    }
        
    @Test
    public void moveUpTest() {
        player.moveUp(10);
        assertEquals(10, player.getY());
    }
    
    @Test
    public void negativeMoveUpTest() {
        player.moveUp(-10);
        assertEquals(0, player.getY());
    }
    
    @Test
    public void moveDownTest() {
        player = new Player(0, 15);
        player.moveDown(10);
        assertEquals(5, player.getY());
    }
    
    @Test
    public void negativeMoveDownTest() {
        player.moveDown(-10);
        assertEquals(0, player.getY());
    }

    /*
    @Test
    public void isPositiveFalseTest() {
        assertFalse(player.isPositive(-1));
    }
    
    @Test
    public void isPositiveTrueTest() {
        assertTrue(player.isPositive(0));
    }
    
    @Test
    public void isPositiveTrueTestTwo() {
        assertTrue(player.isPositive(1));
    }
    */
}
