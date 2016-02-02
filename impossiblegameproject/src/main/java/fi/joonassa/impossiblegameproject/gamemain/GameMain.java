package fi.joonassa.impossiblegameproject.gamemain;

import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamelogic.ActorController;
import fi.joonassa.impossiblegameproject.gui.PaintComponent;
import fi.joonassa.impossiblegameproject.listener.GameListener;
import javax.swing.JPanel;

public class GameMain extends JPanel {

    private boolean gameOver;
    private boolean gamePaused;
    private GameListener gameListener;
    private ActorController actorController;
    private PaintComponent paintComponent;
    public static int WIDTH;
    public static int HEIGHT;

    public static int kierros = 0;
    
    public GameMain(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        actorController = new ActorController();
    }

    public void startGame() {
        initialize();
        
        while (!gameOver) {
            restart();
            while (!gamePaused) {
                gameUpdate();
                paintComponent.repaint();
                /*
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    System.out.println("Problem with Thread.sleep");
                }
                */
            }
        }
    }

    public void gameUpdate() {
        //siirrä kierros logiikka actorControllerille
        if (kierros == 1000) {
            actorController.addObject(200);
        }
        actorController.updateObjects();
        paintComponent.setActors(actorController.getObjects(), actorController.getPlayer());
        if (kierros < 1001) {
            kierros++;
        } else {
            kierros = 0;
        }
        
    }

    public void initialize() {
        gameOver = false;
    }

    public void restart() {
        actorController.restart();
        gamePaused = false;
    }

    public void gameShutdown() {
    }

    public Player getPlayer() {
        return actorController.getPlayer();
    }

    public void setPaintComponent(PaintComponent p) {
        this.paintComponent = p;
    }
}
