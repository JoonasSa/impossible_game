package fi.joonassa.impossiblegameproject.gamelogic;

import fi.joonassa.impossiblegameproject.actors.Actor;
import fi.joonassa.impossiblegameproject.actors.Platform;
import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import java.util.ArrayList;

/**
 * Tämän luokan kautta hallitaan pelin jokaista actoria.
 */
public class ActorController {

    private ArrayList<Actor> objects;
    private Player player;
    private int gameSpeed;

    /**
     * Luo uuden liikkujakontrollerin. Tämän luokan kautta hallitaan liikkujia.
     */
    public ActorController() {
        this.player = new Player(0, 0, 50, 50);
        this.objects = new ArrayList<>();
        gameSpeed = 2;
    }

    /**
     * Lisää uuden objekteja peliin.
     *
     * @param y objektin y arvo.
     */
    public void addObject(int y) {
        objects.add(new Platform(GameMain.width, y, 75, 25));
    }

    /**
     * Lisää uuden objekteja peliin, jolla on satunnainen arvo x.
     *
     * @param y objektin y arvo.
     */
    public void addObjectWithRandom(int y) {
        if (y == 0) {
            objects.add(new Platform(GameMain.width, 200, 75, 25));
        } else if (y == 1) {
            objects.add(new Platform(GameMain.width, 300, 75, 25));
        } else if (y == 2) {
            objects.add(new Platform(GameMain.width, 400, 75, 25));
        } else if (y == 3) {
            objects.add(new Platform(GameMain.width, 500, 75, 25));
        }
    }
    
    /**
     * Kasvattaa alustojen liikkumisnopeutta yhdellä.
     */
    public void increaseGameSpeed() {
        gameSpeed++;
    }

    /**
     * Lisää uuden pelaajan peliin.
     *
     * @param x pelaajan x arvo.
     * @param y pelaajan y arvo.
     */
    public void addPlayer(int x, int y) {
        player = new Player(x, y, 50, 50);
    }

    /**
     * Päivittää pelin objektit.
     *
     * @see actors.Actor#moveLeft(int)
     */
    public void updateObjects() {
        for (Actor x : objects) {
            x.moveLeft(gameSpeed);
        }
    }

    public ArrayList<Actor> getObjects() {
        return objects;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Päivittää pelaajan sijainnin. Tarkistaa mihin suuntaan pelaaja on
     * liikkeessä, sekä onko pelaaja jonkin objektin päällä.
     *
     * @param playerIsStuck on tosi jos pelaaja on objektin päällä
     * @see actors.Player#moveDown(int)
     * @see actors.Player#moveUp(int)
     */
    public void updatePlayer(boolean playerIsStuck) {
        //tän vois hoitaa ilman movingUppia jos yhditetään move metodit
        if (player.movingUp) {
            player.updateJump();
            player.moveUp(player.getJumpSpeed());
        } else {
            if (playerIsStuck) {
                return;
            }
            player.updateJump();
            player.moveDown(player.getJumpSpeed());
        }
    }

    public int getGameSpeed() {
        return gameSpeed;
    }
    
    /**
     * Nollaa pelin objektit.
     */
    public void restart() {
        player.setX(100);
        player.setY(300);
        this.objects = new ArrayList<>();
        objects.add(new Platform(100, 500, 300, 25));
        gameSpeed = 2;
    }

    /**
     * Tarkistaa osuuko pelaaja mihinkään objektiin.
     *
     * @return palauttaa totuusarvona osuuko pelaaja johonkin.
     */
    public boolean collisionTest() {
        for (Actor x : objects) {
            if (player.getX() < x.getX() + x.getWidth()
                    && player.getWidth() + player.getX() > x.getX()
                    && player.getY() < x.getY() + x.getHeight()
                    && player.getHeight() + player.getY() > x.getY()) {
                return true;
            }
        }
        return false;
    }
}
