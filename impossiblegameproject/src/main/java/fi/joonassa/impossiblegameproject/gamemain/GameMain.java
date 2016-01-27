package fi.joonassa.impossiblegameproject.gamemain;

import fi.joonassa.impossiblegameproject.gamelogic.GameController;
import fi.joonassa.impossiblegameproject.gui.PaintComponent;

public class GameMain {

    private boolean gameOver;
    private GameController gameController;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 15;

    public GameMain() {
        gameOver = false;
        gameController = new GameController();
    }

    public void startGame() {
        //initialize();
        while (!gameOver) {
            gameController.updateGame();
            /*
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Problem with Thread.sleep");
            }
            */
            gameController.repaint();
        }
    }
}
