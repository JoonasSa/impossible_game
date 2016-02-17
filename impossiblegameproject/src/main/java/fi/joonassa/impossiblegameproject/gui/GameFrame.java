package fi.joonassa.impossiblegameproject.gui;

import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import fi.joonassa.impossiblegameproject.listener.GameListener;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka luo pelin ikkunan ja hoitaa renderoimista.
 */
public class GameFrame implements Runnable {

    private JFrame frame;
    private GameMain game;

    public GameFrame(GameMain main) {
        game = main;
    }

    /**
     * Metodi luo ikkunan ja paketoi sen sisällön.
     */
    @Override
    public void run() {
        frame = new JFrame("Impossible Game");
        frame.setPreferredSize(new Dimension(800, 600));
        createComponents(frame.getContentPane());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null); // keskitä ikkuna
        frame.setVisible(true);
    }

    /**
     * Metodi lisää ikkunalle kuuntelijan ja grafiikkakomponentin.
     *
     * @param container
     */
    public void createComponents(Container container) {
        frame.addKeyListener(game.getGameListener());
        container.add(game.getPaintComponent());
    }

    public JFrame getFrame() {
        return frame;
    }
}
