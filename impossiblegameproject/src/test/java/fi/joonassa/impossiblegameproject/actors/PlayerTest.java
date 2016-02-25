
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
        player = new Player(0, 0, 0, 0);
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
    public void playerSetXNollaTest() {
        player.setX(0);
        assertEquals(0, player.getX());
    }
    
    @Test
    public void playerSetYTest() {
        player.setY(5);
        assertEquals(5, player.getY());
    } 
    
    @Test
    public void playerSetYNollaTest() {
        player.setY(0);
        assertEquals(0, player.getY());
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
        player = new Player(0, 10, 0, 0);
        player.moveUp(10);
        assertEquals(0, player.getY());
    }
    
    @Test
    public void negativeMoveUpTest() {
        player.moveUp(-10);
        assertEquals(0, player.getY());
    }
    
    @Test
    public void MoveUpZeroTest() {
        player.moveUp(0);
        assertEquals(0, player.getY());
    }
    
    @Test
    public void moveDownTest() {
        player = new Player(0, 15, 0, 0);
        player.moveDown(10);
        assertEquals(25, player.getY());
    }
    
    @Test
    public void negativeMoveDownTest() {
        player.moveDown(-10);
        assertEquals(0, player.getY());
    }
    
    @Test
    public void MoveDownZeroTest() {
        player.moveDown(0);
        assertEquals(0, player.getY());
    }

    @Test
    public void newPlayerNegativeX() {
        Player x = new Player(-1,1, 0, 0);
        assertEquals(0, x.getX());
    }
    
    @Test
    public void newPlayerNegativeY() {
        Player x = new Player(1,-1, 0, 0);
        assertEquals(0, x.getY());
    }
    
    @Test
    public void parseInputTest1() {
        player.movingUp = false;
        player.canJump = true;
        player.parseInput(true);
        assertEquals(1, player.getJumpSpeed());
    }
    
    @Test
    public void parseInputTest2() {
        player.movingUp = false;
        player.canJump = true;
        player.parseInput(false);
        assertEquals(1, player.getJumpSpeed());
    }
    
    @Test
    public void parseInputTest3() {
        player.movingUp = false;
        player.canJump = false;
        player.parseInput(true);
        assertEquals(1, player.getJumpSpeed());
    }
    
    @Test
    public void parseInputTest4() {
        player.movingUp = true;
        player.canJump = true;
        player.parseInput(true);
        assertEquals(1, player.getJumpSpeed());
    }
    
    @Test
    public void parseInputTest5() {
        player.jump();
        player.parseInput(true);
        assertEquals(2, player.getJumpSpeed());
    }
    
    @Test
    public void updateJumpTest() {
        player.jump();
        for (int i = 0; i < 50; i++) {
            player.updateJump();
        }
        assertEquals(player.movingUp, false);
    }
}
