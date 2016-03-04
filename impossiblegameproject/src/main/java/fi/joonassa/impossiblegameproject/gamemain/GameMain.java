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
    private boolean newGame;
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
        newGame = true;
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
        if (newGame) {
            newGame();
        }
        restart();
        while (!gameQuit) {
            paintComponent.updatePaintComponent(actorController.getObjects(), actorController.getPlayer(), true);
            paintComponent.repaint();
            while (!gamePaused) {
                gameUpdate();
                try {
                    //optimaalinen pelinopeus
                    Thread.sleep(9);
                } catch (Exception e) {
                    System.out.println("Problem with Thread.sleep, happened in gamePaused loop.");
                }
            }
            try {
                //tekee pause toiminnallisuuden sujuvammaksi
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Problem with Thread.sleep, happened in gameQuit loop.");
            }
        }
    }

    private void gameUpdate() {
        if (gameListener.getDidPlayerRestart()) {;
            startGame();
        } else if (actorController.playerIsDead()) {
            gameEndAnimation();
            startGame();
        } else if (score % 1000 == 0) {
            actorController.makeGameHarder();
        }
        score++;
        updateActors();
        updateScreen();
    }

    private void updateActors() {
        actorController.updateSpawn();
        actorController.updateObjects();
        touchedPlatform = actorController.collisionTest();
        Player.canJump = touchedPlatform;
        actorController.getPlayer().parseInput(gameListener.getDidPlayerJump());
        actorController.updatePlayer(touchedPlatform);
    }

    private void updateScreen() {
        paintComponent.updatePaintComponent(actorController.getObjects(), actorController.getPlayer(), false);
        paintComponent.repaint();
    }

    private void gameEndAnimation() {
        while (actorController.getPlayer().getY() < GameMain.height) {
            actorController.getPlayer().moveDown(3);
            updateScreen();
            try {
                //optimaalinen pelinopeus
                Thread.sleep(9);
            } catch (Exception e) {
                System.out.println("Problem with Thread.sleep, happened in gameEndAnimation loop.");
            }
        }
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

    private void newGame() {
        gamePaused = true;
        while (gamePaused) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("Problem with Thread.sleep, happened in newGame loop.");
            }
        }
        newGame = false;
        paintComponent.setNewgameFalse();
    }

    public PaintComponent getPaintComponent() {
        return paintComponent;
    }

    public GameListener getGameListener() {
        return gameListener;
    }
}
