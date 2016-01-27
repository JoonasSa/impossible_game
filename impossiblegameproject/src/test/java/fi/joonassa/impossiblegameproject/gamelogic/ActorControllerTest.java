
package fi.joonassa.impossiblegameproject.gamelogic;

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
    
    //tää testi tulee muuttaa jahka objectien lisäys laittaa 
    //objectin x = GameMain.WIDTH
    @Test
    public void updateObjectsTest() {
        controller.addObject(0);
        controller.updateObjects();
        assertEquals(9, controller.getObjects().get(0).getX());
    }
    
    @Test
    public void updateManyObjectsTest() {
        controller.addObject(0);
        controller.addObject(0);
        controller.addObject(0);
        controller.updateObjects();
        assertEquals(9, controller.getObjects().get(0).getX());
        assertEquals(9, controller.getObjects().get(1).getX());
        assertEquals(9, controller.getObjects().get(2).getX());
    }
    
    @Test
    public void updatePlayerUpTest() {
        controller.updatePlayerUp(10);
        assertEquals(10, controller.getPlayer().getY());
    }
    
    @Test
    public void updatePlayerDownTest() {
        controller.addPlayer(0, 10);
        controller.updatePlayerDown(10);
        assertEquals(0, controller.getPlayer().getY());
    }
}
