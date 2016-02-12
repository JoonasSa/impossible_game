package fi.joonassa.impossiblegameproject.gamemain;

import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamelogic.ActorController;
import fi.joonassa.impossiblegameproject.gui.PaintComponent;
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
    private Random random;
    /**
     * Pelialueen mitat.
     */
    public static int width;
    public static int height;

    public static int kierros = 0;

    public GameMain(int width, int height) {
        this.width = width;
        this.height = height;
        actorController = new ActorController();
        paintComponent = new PaintComponent();
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
        if (kierros == 200) {
            actorController.addObjectWithRandom(random.nextInt(3));
            kierros = 0;
        }
        actorController.updateObjects();
        actorController.updatePlayer(actorController.collisionTest());
        paintComponent.setActors(actorController.getObjects(), actorController.getPlayer());
        kierros++;
    }

    private void initialize() {
        gameOver = false;
    }

    private void restart() {
        actorController.restart();
        gamePaused = false;
        random = new Random();
    }

    private void gameShutdown() {
    }

    public Player getPlayer() {
        return actorController.getPlayer();
    }

    public PaintComponent getPaintComponent() {
        return paintComponent;
    }
}
