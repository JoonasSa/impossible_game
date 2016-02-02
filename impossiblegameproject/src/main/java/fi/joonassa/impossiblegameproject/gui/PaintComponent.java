package fi.joonassa.impossiblegameproject.gui;

import fi.joonassa.impossiblegameproject.actors.Actor;
import fi.joonassa.impossiblegameproject.actors.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintComponent extends JPanel {

    private ArrayList<Actor> actors = null;
    private Player player = null;

    public PaintComponent() {
        //todennäköisesti aivan turhaa
        //setFocusable(true);  // so that this can receive key-events
        //requestFocus();
        //setBackground(Color.WHITE);
    }

    public void setActors(ArrayList<Actor> l, Player p) {
        actors = l;
        player = p;
    }

    // Kutsutaan uudestaan: repaint().
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;  // if using Java 2D
        super.paintComponent(g2d);       // paint background
        setBackground(Color.BLACK);      // may use an image for background
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(0, 0, 30, 30);
        if (actors != null) {
            for (Actor x : actors) {
                g2d.fillRect(x.getX(), x.getY(), 50, 15);
            }
        }
        if (player != null) {
            g2d.fillOval(player.getX(), player.getY(), 40, 40);
        }

    }
}
