package fi.joonassa.impossiblegameproject.gamemain;

import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamelogic.ActorController;
import fi.joonassa.impossiblegameproject.gui.PaintComponent;
import fi.joonassa.impossiblegameproject.listener.GameListener;
import java.util.Random;
import javax.swing.JPanel;
/**
 * Luokka pyörittää pelilooppia ja kutsuu muita pelin komponentteja. 
 */
public class GameMain extends JPanel {

    private boolean gameOver;
    private boolean gamePaused;
    private ActorController actorController;
    private PaintComponent paintComponent;
    private GameListener gameListener;
    private Random random;
    private boolean touchedPlatform;
    private int gameSpeed;
            
    /**
     * Pelialueen mitat.
     */
    public static int width;
    public static int height;

    public static int spawnPlatform;

    public GameMain(int width, int height) {
        this.width = width;
        this.height = height;
        actorController = new ActorController();
        paintComponent = new PaintComponent();
        gameListener = new GameListener();
    }
    
    /**
     * Käynnistää pääohjelman ja on peliloop. Tämä metodi pyörii kokoajan pelinalustamisen jälkeen.
     * @see gui.paintComponent#repaint();
     */
    public void startGame() {
        initialize();
        while (!gameOver) {
            restart();
            while (!gamePaused) {
                gameUpdate();
                paintComponent.repaint();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println("Problem with Thread.sleep");
                }
            }
        }
    }

    private void gameUpdate() {
        //siirrä kierros logiikkaa actorControllerille
        if (spawnPlatform == 0) {
            actorController.addObjectWithRandom(random.nextInt(3));
        }
        actorController.updateObjects();
        touchedPlatform = actorController.collisionTest();
        Player.canJump = touchedPlatform;
        actorController.getPlayer().parseInput(gameListener.getDidPlayerJump());
        actorController.updatePlayer(touchedPlatform);
        paintComponent.setActors(actorController.getObjects(), actorController.getPlayer());
        spawnPlatform++;
        if (spawnPlatform > 200) {
            spawnPlatform = 0;
        }
        /*
        gameSpeed++;
        if (gameSpeed % 1000 == 0) {
            actorController.increaseGameSpeed();
            gameSpeed = 0;
        }
        */
    }

    private void initialize() {
        gameOver = false;
    }

    private void restart() {
        actorController.restart();
        gamePaused = false;
        random = new Random();
        touchedPlatform = false;
        gameSpeed = 1;
        spawnPlatform = 0;
    }

    private void gameShutdown() {
    }

    public PaintComponent getPaintComponent() {
        return paintComponent;
    }
    
    public GameListener getGameListener() {
        return gameListener;
    }
}
