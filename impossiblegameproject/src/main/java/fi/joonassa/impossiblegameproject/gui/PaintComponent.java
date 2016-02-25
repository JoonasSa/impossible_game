package fi.joonassa.impossiblegameproject.gui;

import fi.joonassa.impossiblegameproject.actors.Actor;
import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Tuottaa ikkunan sisällön. Eli siis pelin elementit ja tapahtumat.
 * @author sarapajo
 */
public class PaintComponent extends JPanel {

    private ArrayList<Actor> actors = null;
    private Player player = null;
    //private HashMap<Integer, Integer> stars = null;
    //private Font myFont = new Font("Ubuntu Mono", Font.BOLD, 70);
    private Font myFont = new Font("It wasn't me", Font.BOLD, 60);
    private FontMetrics metric = getFontMetrics(myFont);
    private int textWidth;
    private String score;
    
    /*
    public PaintComponent() {
        
        Random random = new Random();
        stars = new HashMap();
        int tahtia = random.nextInt(100);
        for (int i = 0; i < tahtia + 100; i++) {
            stars.put(random.nextInt(440000));
        }
        
        
    }
    */ 
    
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
        setBackground(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        if (actors != null) {
            for (Actor x : actors) {
                g2d.fillRect(x.getX() + 7, x.getY() + 5, x.getWidth() - 12, x.getHeight() - (int) (x.getHeight() * 0.8));
                g2d.drawRect(x.getX(), x.getY(), x.getWidth(), x.getHeight());
            }
        }
        if (player != null) {
            g2d.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
            //g2d.fillRect(player.getX() + 7, player.getY() + 7, player.getWidth() - 17, player.getHeight() - 15);
        }
        g2d.setFont(myFont);
        score = "" + (GameMain.score / 10) + "0";
        textWidth = metric.stringWidth(score);
        g2d.drawString(score, GameMain.width - textWidth - 10, 50);
        if (GameMain.highscore == 0) {
            g2d.drawString("0", 10, 50);
        } else {
            g2d.drawString("" + (GameMain.highscore / 10) + "0", 10, 50);
        }
        /*
        for (Integer x : stars) {
            g2d.fillRect(x / 400, x / 1100, 4, 4);
        }
        /*
        score = "" + GameMain.score;
        for (int i = score.length() - 1; i > 0; i--) {
            textWidth = metric.stringWidth(score.substring(i, i + 1));
            g2d.drawString(score.substring(i, i + 1), GameMain.width - textWidth * (i + 1), 50); 
        }
        */
    }
}
