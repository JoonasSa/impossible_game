
package fi.joonassa.impossiblegameproject.gamelogic;

import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActorControllerTest {
    ActorController controller;
    
    public ActorControllerTest() {
    }

    @Before
    public void setUp() {
        controller = new ActorController();
    }

    @Test
    public void addObjectTest() {
        controller.addObject(0);
        assertEquals(1, controller.getObjects().size());
    }
    
    @Test
    public void addManyObjectsTest() {
        for (int i = 0; i < 10; i++) {
            controller.addObject(0);
        }
        assertEquals(10, controller.getObjects().size());
    } 
    
    @Test
    public void addPlayerTest() {
        controller.addPlayer(0, 0);
        assertEquals(0, controller.getPlayer().getX());
    }
    
    @Test
    public void addPlayerWithWrongParamatersTest() {
        controller.addPlayer(-1, 0);
        assertEquals(0, controller.getPlayer().getX());
    }
    
    //tää testi tulee muuttaa jahka objectien lisäys laittaa 
    //objectin x = GameMain.WIDTH
    @Test
    public void updateObjectsTest() {
        controller.addObject(0);
        controller.updateObjects();
        assertEquals(GameMain.width - 2, controller.getObjects().get(0).getX());
    }
    
    @Test
    public void updateManyObjectsTest() {
        controller.addObject(0);
        controller.addObject(0);
        controller.addObject(0);
        controller.updateObjects();
        assertEquals(GameMain.width - 2, controller.getObjects().get(0).getX());
        assertEquals(GameMain.width - 2, controller.getObjects().get(1).getX());
        assertEquals(GameMain.width - 2, controller.getObjects().get(2).getX());
    }
    
    @Test
    public void restartPlayerXTest() {
        controller.restart();
        assertEquals(100, controller.getPlayer().getX());
    }
    
    @Test
    public void restartPlayerYTest() {
        controller.restart();
        assertEquals(300, controller.getPlayer().getY());
    }
    
    @Test
    public void restartObjectsTest() {
        controller.restart();
        assertEquals(1, controller.getObjects().size());
    }
    
    @Test
    public void updatePlayerUpTest() {
        controller.addPlayer(10, 20);
        controller.getPlayer().jump();
        controller.updatePlayer(false);
        System.out.println(controller.getPlayer().getY());
        assertEquals(11, controller.getPlayer().getY());
    }
    
    @Test
    public void updatePlayerDownTest() {
        controller.addPlayer(10, 10);
        controller.getPlayer().drop();
        controller.updatePlayer(false);
        assertEquals(11, controller.getPlayer().getY());
    }
    
    @Test
    public void updatePlayerIsStuckTest() {
        controller.addPlayer(10, 10);
        controller.updatePlayer(true);
        assertEquals(10, controller.getPlayer().getY());
    }
    
    @Test
    public void collisionTrueTest() {
        controller.addPlayer(GameMain.width, 10);
        controller.addObject(10);
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionFalseTest() {
        controller.addPlayer(10, 10);
        controller.addObject(10);
        assertEquals(true, controller.collisionTest());
    }
}
