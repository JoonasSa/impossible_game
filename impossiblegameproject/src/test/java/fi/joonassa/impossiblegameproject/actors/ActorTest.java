
package fi.joonassa.impossiblegameproject.actors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActorTest {
    
    Actor actor;
    
    public ActorTest() {
    }

    @Before
    public void setUp() {
        actor = new Actor(0, 0);
    }
    
    @Test
    public void newActorNegativeXTest() {
        actor = new Actor(-1, 0);
        assertEquals(0, actor.getX());
    }
    
    @Test
    public void newActorNegativeYTest() {
        actor = new Actor(0, -1);
        assertEquals(0, actor.getY());
    }
    
    @Test
    public void newActorNegativeXYTest() {
        actor = new Actor(-1, -1);
        assertEquals(0, actor.getX());
        assertEquals(0, actor.getY());
    }

    //get & set-testit ovat tällä hetkellä hiukan turhia, mutta tulevaisuudessa 
    //niillä varmistetaan etteivät Actorit pääse ulos pelialueelta
    @Test
    public void actorGetXTest() {
        assertEquals(0, actor.getX());
    }
    
    @Test
    public void actorGetYTest() {
        assertEquals(0, actor.getY());
    }
    
    @Test
    public void actorSetXTest() {
        actor.setX(5);
        assertEquals(5, actor.getX());
    }
    
    @Test
    public void actorSetYTest() {
        actor.setY(5);
        assertEquals(5, actor.getY());
    }

    @Test 
    public void actorSetNegativeXTest() {
        actor.setX(-5);
        assertEquals(0, actor.getX());
    }
    
    @Test 
    public void actorSetNegativeYTest() {
        actor.setY(-5);
        assertEquals(0, actor.getY());
    }
    
    @Test 
    public void actorSetNollaYTest() {
        actor.setY(0);
        assertEquals(0, actor.getY());
    }
    
    @Test 
    public void actorSetNollaXTest() {
        actor.setX(0);
        assertEquals(0, actor.getX());
    }
    
    @Test
    public void moveLeftTest() {
        actor = new Actor(15, 0);
        actor.moveLeft(10);
        assertEquals(5, actor.getX());
    }
    
    @Test
    public void negativeMoveLeftTest() {
        actor.moveLeft(-10);
        assertEquals(0, actor.getX());
    }
    
    @Test
    public void moveLeftNollaTest() {
        actor = new Actor(15, 0);
        actor.moveLeft(0);
        assertEquals(15, actor.getX());
    }
} 
