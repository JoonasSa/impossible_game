package fi.joonassa.impossiblegameproject;

import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import fi.joonassa.impossiblegameproject.gui.GameFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        GameMain game = new GameMain(800, 600);
        GameFrame frame = new GameFrame(game);
        SwingUtilities.invokeLater(frame);
        game.startGame();
    }
}
