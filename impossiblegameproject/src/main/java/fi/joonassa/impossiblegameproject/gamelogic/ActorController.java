
package fi.joonassa.impossiblegameproject.gamelogic;

import fi.joonassa.impossiblegameproject.actors.Actor;
import fi.joonassa.impossiblegameproject.actors.Platform;
import fi.joonassa.impossiblegameproject.actors.Player;
import java.util.ArrayList;

public class ActorController {
    private ArrayList<Actor> objects;
    private Player player;
    
    public ActorController() {
        this.player = new Player(0, 0);
        this.objects = new ArrayList<>();
    }
    
    public void addObject(int y) {
        //x kuuluisi olla GameMain.WIDTH
        objects.add(new Platform(10 ,y));
    }
    
    public void addPlayer(int x, int y) {
        player = new Player(x, y);
    }
    
    public void updateObjects() {
        for (Actor x : objects) {
            x.moveLeft(1);
        }
    }

    public ArrayList<Actor> getObjects() {
        return objects;
    }

    public Actor getPlayer() {
        return player;
    }

    public void updatePlayerUp(int amount) {
        player.moveUp(amount);
    }
    
    public void updatePlayerDown(int amount) {
        player.moveDown(amount);
    }
}
