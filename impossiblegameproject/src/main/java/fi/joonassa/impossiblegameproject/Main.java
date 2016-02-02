package fi.joonassa.impossiblegameproject;

import fi.joonassa.impossiblegameproject.gui.GameFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        SwingUtilities.invokeLater(frame);
        frame.startGame();
    }
}
