package fi.joonassa.impossiblegameproject.gui;

import fi.joonassa.impossiblegameproject.actors.Actor;
import fi.joonassa.impossiblegameproject.actors.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Tuottaa ikkunan sisällön. Eli siis pelin elementit ja tapahtumat.
 * @author sarapajo
 */
public class PaintComponent extends JPanel {

    private ArrayList<Actor> actors = null;
    private Player player = null;

    /**
     * Asettaa PaintComponentille renderoitavat liikkujat.
     * @param l lista liikkujia
     * @param p pelaaja
     */
    public void setActors(ArrayList<Actor> l, Player p) {
        actors = l;
        player = p;
    }

    /**
     * Kutsuu yläluokkansa metodia repaint() ja renderöi ruudun sisällön uudestaan.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;    // Java 2D
        super.paintComponent(g2d);        
        setBackground(Color.BLACK);         // background
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        if (actors != null) {
            for (Actor x : actors) {
                g2d.drawRect(x.getX(), x.getY(), x.getWidth(), x.getHeight());
            }
        }
        if (player != null) {
            g2d.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }

    }
}
