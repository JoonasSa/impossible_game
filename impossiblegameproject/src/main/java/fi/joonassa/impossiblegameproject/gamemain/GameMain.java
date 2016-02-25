package fi.joonassa.impossiblegameproject.gamemain;

import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamelogic.ActorController;
import fi.joonassa.impossiblegameproject.gui.PaintComponent;
import fi.joonassa.impossiblegameproject.listener.GameListener;
import javax.swing.JPanel;

/**
 * Luokka pyörittää pelilooppia ja kutsuu muita pelin komponentteja.
 */
public class GameMain extends JPanel {

    private ActorController actorController;
    private PaintComponent paintComponent;
    private GameListener gameListener;
    private boolean touchedPlatform;
    /**
     * Pelintilat.
     */
    public static boolean gamePaused;
    public static boolean gameQuit;
    /**
     * Pelaajan nykyiset pisteet ja parhaat pisteet.
     */
    public static int score;
    public static int highscore;
    /**
     * Pelialueen mitat.
     */
    public static int width;
    public static int height;

    public GameMain(int width, int height) {
        this.width = width;
        this.height = height;
        gameQuit = false;
        actorController = new ActorController();
        paintComponent = new PaintComponent();
        gameListener = new GameListener();
    }

    /**
     * Käynnistää pääohjelman ja on peliloop. Tämä metodi pyörii kokoajan
     * pelinalustamisen jälkeen.
     *
     * @see gui.paintComponent#repaint();
     */
    public void startGame() {
        restart();
        while (!gameQuit) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Problem with Thread.sleep");
            }
            while (!gamePaused) {
                gameUpdate();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println("Problem with Thread.sleep");
                }
            }
        }
    }

    private void gameUpdate() {
        if (gameListener.getDidPlayerRestart() || actorController.playerIsDead()) {
            startGame();
        } else if (score % 1000 == 0) {
            actorController.makeGameHarder();
        }
        actorController.updateSpawn();
        actorController.updateObjects();
        touchedPlatform = actorController.collisionTest();
        Player.canJump = touchedPlatform;
        actorController.getPlayer().parseInput(gameListener.getDidPlayerJump());
        actorController.updatePlayer(touchedPlatform);
        paintComponent.setActors(actorController.getObjects(), actorController.getPlayer());
        score++;
        paintComponent.repaint();
    }

    private void restart() {
        if (score > highscore) {
            highscore = score;
        }
        actorController.restart();
        gamePaused = false;
        touchedPlatform = false;
        score = 0;
    }

    public PaintComponent getPaintComponent() {
        return paintComponent;
    }

    public GameListener getGameListener() {
        return gameListener;
    }
}
