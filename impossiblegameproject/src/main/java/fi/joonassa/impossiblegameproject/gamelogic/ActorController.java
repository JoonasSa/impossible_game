package fi.joonassa.impossiblegameproject.gamelogic;

import fi.joonassa.impossiblegameproject.actors.Actor;
import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import java.util.ArrayList;
import java.util.Random;

/**
 * Tämän luokan kautta hallitaan pelin jokaista actoria.
 */
public class ActorController {

    private ArrayList<Actor> objects;
    private Player player;
    private Random random;
    private int spawnPlatform;
    private int difficulty;
    private int gameSpeed;
    private boolean playerDead;

    /**
     * Luo uuden liikkujakontrollerin. Tämän luokan kautta hallitaan liikkujia.
     */
    public ActorController() {
        this.objects = new ArrayList<>();
        gameSpeed = 2;
        random = new Random();
    }

    /**
     * Lisää uuden objekteja peliin, jolla on satunnainen arvo x.
     *
     * @param forTesting parametri vain testejä varten.
     */
    public void addObjectWithRandom(int forTesting) {
        int y = forTesting;
        if (forTesting == -1) {
            y = random.nextInt(3);
        }
        if (y == 0) {
            objects.add(new Actor(GameMain.width, GameMain.height - 100, random.nextInt(50) + 200 - 25 * difficulty, 25));
        } else if (y == 1) {
            objects.add(new Actor(GameMain.width, GameMain.height - 200, random.nextInt(50) + 200 - 25 * difficulty, 25));
        } else if (y == 2) {
            objects.add(new Actor(GameMain.width, GameMain.height - 300, random.nextInt(50) + 200 - 25 * difficulty, 25));
        }
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

    /**
     * Lisää alustoja peliin tasaisin ajoin.
     */
    public void updateSpawn() {
        if (spawnPlatform == 0) {
            addObjectWithRandom(-1);
        }
        spawnPlatform++;
        if (spawnPlatform > 200) {
            spawnPlatform = 0;
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

    /**
     * Nollaa pelin objektit.
     */
    public void restart() {
        this.player = new Player(0, 0, 50, 50);
        player.setX(100);
        player.setY(300);
        this.objects = new ArrayList<>();
        objects.add(new Actor(100, GameMain.height - 300, GameMain.width / 2, 25));
        difficulty = 1;
        spawnPlatform = 0;
        playerDead = false;
    }

    /**
     * Hankaloittaa peliä kasvattamalla muuttujaa difficulty, mikä pienentä
     * alustojen kokoa keskimääräisesti.
     */
    public void makeGameHarder() {
        if (difficulty <= 6) {
            difficulty++;
        }
    }

    public int getDifficulty() {
        return difficulty;
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
                //sidehit
                if ((player.getX() + player.getWidth() <= x.getX() || player.getX() + player.getWidth() >= x.getX() + 5)
                        || player.getY() + player.getHeight() <= x.getY() + 5) {
                    return true;
                } else {
                    playerDead = true;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkistaa onko pelaaja pelialueen ulkopuolella.
     *
     * @return boolean arvon joka kuvastaa onko pelaaja pelialueen ulkopuolella
     */
    public boolean playerIsDead() {
        if (playerDead) {
            return true;
        }
        return player.getY() >= GameMain.height;
    }

    /**
     * Lisää uuden objekteja peliin. Käytetään vain testauksessa.
     *
     * @param y objektin y koordinaatti.
     */
    public void addObject(int y) {
        objects.add(new Actor(GameMain.width, y, 100, 25));
    }

    /**
     * Lisää uuden objekteja peliin. Käytetään vain testauksessa.
     *
     * @param x objektin x koordinaatti.
     * @param y objektin y koordinaatti.
     * @param width objektin leveys.
     * @param height objektin korkeus.
     */
    public void addObject(int x, int y, int width, int height) {
        objects.add(new Actor(x, y, width, height));
    }

    /**
     * Lisää uuden pelaaja peliin. Käytetään vain testauksessa.
     *
     * @param x pelaajan x koordinaatti.
     * @param y pelaajan y koordinaatti.
     */
    public void addPlayer(int x, int y) {
        player = new Player(x, y, 50, 50);
    }
}
