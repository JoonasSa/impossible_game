package fi.joonassa.impossiblegameproject.gui;

import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import fi.joonassa.impossiblegameproject.listener.GameListener;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameFrame implements Runnable {
    
    JFrame frame;
    GameMain game;

    @Override
    public void run() {
        game = new GameMain(800, 600);
        frame = new JFrame("Impossible Game");
        frame.setPreferredSize(new Dimension(800, 600));
        createComponents(frame.getContentPane());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // center the application window
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {
        PaintComponent p = new PaintComponent();
        container.add(p);
        container.addKeyListener(new GameListener(game.getPlayer()));
        game.setPaintComponent(p);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public void startGame() {
        game.startGame();
    }
}

        