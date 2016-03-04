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
    GameMain main;

    public ActorControllerTest() {
    }

    @Before
    public void setUp() {
        controller = new ActorController();
        main = new GameMain(1100, 800);
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
    public void restartPlatformTest1() {
        controller.restart();
        assertEquals(100, controller.getObjects().get(0).getX());
    }
    
    @Test
    public void restartPlatformTest2() {
        controller.restart();
        assertEquals(GameMain.height - 300, controller.getObjects().get(0).getY());
    }
    
    @Test
    public void restartPlatformTest3() {
        controller.restart();
        assertEquals(GameMain.width / 2, controller.getObjects().get(0).getWidth());
    }
    
    @Test
    public void restartPlatformTest4() {
        controller.restart();
        assertEquals(25, controller.getObjects().get(0).getHeight());
    }

    @Test
    public void updatePlayerUpTest() {
        controller.addPlayer(10, 20);
        controller.getPlayer().jump();
        controller.updatePlayer(false);
        assertEquals(19, controller.getPlayer().getY());
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
    public void updatePlayerTest1() {
        controller.addPlayer(10, 10);
        controller.getPlayer().jump();
        controller.getPlayer().setSpeed(100);
        controller.updatePlayer(false);
        assertEquals(98, controller.getPlayer().getJumpSpeed());
    }

    @Test
    public void updatePlayerTest2() {
        controller.addPlayer(10, 10);
        controller.getPlayer().drop();
        controller.getPlayer().setSpeed(5.9);
        controller.updatePlayer(false);
        assertEquals(6, controller.getPlayer().getJumpSpeed());
    }

    @Test
    public void collisionTrueTest() {
        controller.addPlayer(GameMain.width, 10);
        controller.addObject(10);
        assertEquals(true, controller.collisionTest());
    }

    @Test
    public void collisionFalseTest() {
        controller.restart();
        assertEquals(false, controller.collisionTest());
    }
    
    @Test
    public void collisionTest1() {
        controller.restart();
        controller.getPlayer().setY(controller.getObjects().get(0).getY());
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionTest2() {
        controller.restart();
        controller.getPlayer().setX(90);
        controller.getPlayer().setY(controller.getObjects().get(0).getY());
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionTest3() {
        controller.restart();
        controller.getPlayer().setY(controller.getObjects().get(0).getY() - 10);
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionTest4() {
        controller.restart();
        controller.getPlayer().setY(controller.getObjects().get(0).getY() - 100);
        assertEquals(false, controller.collisionTest());
    }
    
    @Test
    public void collisionTest5() {
        controller.restart();
        controller.getPlayer().setY(controller.getObjects().get(0).getY() + 100);
        assertEquals(false, controller.collisionTest());
    }
    
    @Test
    public void collisionTest6() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() - 200);
        assertEquals(false, controller.collisionTest());
    }
    
    @Test
    public void collisionTest7() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() + 200);
        assertEquals(false, controller.collisionTest());
    }

    @Test
    public void collisionTest8() {
        controller.restart();
        controller.getPlayer().setY(controller.getObjects().get(0).getY() + 10);
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionTest9() {
        controller.restart();
        controller.addObject(0, 0, GameMain.width, GameMain.height);
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionTestForSideHit1() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() - 49);
        controller.getPlayer().setY(controller.getObjects().get(0).getY());
        assertEquals(true, controller.collisionTest());
    }
    
    @Test
    public void collisionTestForSideHit2() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() - 50);
        controller.getPlayer().setY(controller.getObjects().get(0).getY());
        assertEquals(false, controller.collisionTest());
    }
    
    @Test
    public void collisionTestForSideHit3() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() - 52);
        controller.getPlayer().setY(controller.getObjects().get(0).getY());
        assertEquals(false, controller.collisionTest());
    }
    
    @Test
    public void collisionTestForSideHit4() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() - 49);
        controller.getPlayer().setY(controller.getObjects().get(0).getY() - 49);
        assertEquals(true, controller.collisionTest());
    }

    @Test
    public void updateSpawnTest1() {
        controller.restart();
        controller.updateSpawn();
        assertEquals(2, controller.getObjects().size());
    }

    @Test
    public void updateSpawnTest2() {
        controller.restart();
        for (int i = 0; i < 300; i++) {
            controller.updateSpawn();
        }
        assertEquals(3, controller.getObjects().size());
    }
    
    @Test
    public void updateSpawnTest3() {
        controller.restart();
        for (int i = 0; i < 202; i++) {
            controller.updateSpawn();
        }
        assertEquals(3, controller.getObjects().size());
    }
    
    @Test
    public void updateSpawnTest4() {
        controller.restart();
        for (int i = 0; i < 200; i++) {
            controller.updateSpawn();
        }
        assertEquals(2, controller.getObjects().size());
    }

    @Test
    public void makeGameHarderTest1() {
        controller.restart();
        controller.makeGameHarder();
        assertEquals(2, controller.getDifficulty());
    }

    @Test
    public void makeGameHarderTest2() {
        controller.restart();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        assertEquals(7, controller.getDifficulty());
    }

    @Test
    public void makeGameHarderTest3() {
        controller.restart();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        controller.makeGameHarder();
        assertEquals(7, controller.getDifficulty());
    }
    
    @Test
    public void addObjectWithRandom0YTest() {
        controller.restart();
        controller.addObjectWithRandom(0);
        assertEquals(main.height - 100, controller.getObjects().get(1).getY());
    }
    
    @Test
    public void addObjectWithRandom0XTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(main.width, controller.getObjects().get(1).getX());
    }
    
    @Test
    public void addObjectWithRandom0HeightTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(25, controller.getObjects().get(1).getHeight());
    }
    
    @Test
    public void addObjectWithRandom1YTest() {
        controller.restart();
        controller.addObjectWithRandom(1);
        assertEquals(main.height - 200, controller.getObjects().get(1).getY());
    }
    
    @Test
    public void addObjectWithRandom1XTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(main.width, controller.getObjects().get(1).getX());
    }
    
    @Test
    public void addObjectWithRandom1HeightTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(25, controller.getObjects().get(1).getHeight());
    }
    
    @Test
    public void addObjectWithRandom2YTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(main.height - 300, controller.getObjects().get(1).getY());
    }
    
    @Test
    public void addObjectWithRandom2XTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(main.width, controller.getObjects().get(1).getX());
    }
    
    @Test
    public void addObjectWithRandom2HeightTest() {
        controller.restart();
        controller.addObjectWithRandom(2);
        assertEquals(25, controller.getObjects().get(1).getHeight());
    }
    
    @Test
    public void PlayerIsDeadTrueTest() {
        controller.restart();
        controller.getPlayer().setY(main.height + 1);
        assertTrue(controller.playerIsDead());
    }
    
    @Test
    public void PlayerIsDeadFalseTest() {
        controller.restart();
        controller.getPlayer().setY(main.height - 1);
        assertFalse(controller.playerIsDead());
    }
    
    @Test
    public void PlayerIsDeadTrueTest2() {
        controller.restart();
        controller.getPlayer().setY(main.height);
        assertTrue(controller.playerIsDead());
    }
    
    @Test
    public void PlayerHitsPlatformTest() {
        controller.restart();
        controller.getPlayer().setX(controller.getObjects().get(0).getX() - 49);
        controller.getPlayer().setY(controller.getObjects().get(0).getY());
        controller.collisionTest();
        assertEquals(true, controller.playerIsDead());
    }    
}
