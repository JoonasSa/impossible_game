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
 *
 * @author sarapajo
 */
public class PaintComponent extends JPanel {

    private ArrayList<Actor> actors = null;
    private Player player = null;
    private HashMap<Integer, ArrayList<Integer>> stars = null;
    private Font myFont;
    private FontMetrics metric;
    private int textWidth;
    private String score;
    private Random random;
    private boolean gameIsPaused;
    private boolean newGame;
    
    /**
     * Konstruktorissa luodaan ArrayList renderöitävistä tähdistä.
     */
    public PaintComponent() {
        gameIsPaused = false;
        random = new Random();
        stars = new HashMap();
        newGame = true;
        int leveys = 0;
        for (int i = 0; i < 200; i++) {
            leveys = random.nextInt(GameMain.width);
            if (stars.get(leveys) == null) {
                stars.put(leveys, new ArrayList());
            }
            stars.get(leveys).add(random.nextInt(GameMain.height));
        }
    }

    /**
     * Asettaa PaintComponentille renderoitavat liikkujat.
     *
     * @param list lista liikkujia
     * @param p pelaaja
     * @param paused käytetään paused ruudun oikein renderöintiin
     */
    public void updatePaintComponent(ArrayList<Actor> list, Player p, boolean paused) {
        actors = list;
        player = p;
        gameIsPaused = paused;
    }
    
    /**
     * Asettaa boolean newGame falseksi. Aloitusruudun logiikkaa varten.
     */
    public void setNewgameFalse() {
        newGame = false;
    }

    /**
     * Kutsuu yläluokkansa metodia repaint() ja renderöi ruudun sisällön
     * uudestaan.
     *
     * @param g Graphics grafiikka olio
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        setBackground(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (newGame) {
            renderStars(g2d);
            renderNewGame(g2d);
            return;
        }
        renderStars(g2d);
        renderActors(g2d);
        renderScore(g2d);
        if (gameIsPaused) {
            renderPaused(g2d);
        }
    }

    private void renderActors(Graphics g2d) {
        if (actors != null) {
            for (Actor x : actors) {
                g2d.setColor(Color.BLACK);
                g2d.fillRect(x.getX(), x.getY(), x.getWidth(), x.getHeight());
                g2d.setColor(Color.WHITE);
                g2d.fillRect(x.getX() + 7, x.getY() + 5, x.getWidth() - 12, x.getHeight() - (int) (x.getHeight() * 0.8));
                g2d.drawRect(x.getX(), x.getY(), x.getWidth(), x.getHeight());
            }
        }
        if (player != null) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
            g2d.setColor(Color.WHITE);
            g2d.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }
    }

    private void renderPaused(Graphics g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(myFont);
        score = "Current Score: " + (GameMain.score / 10) + "0";
        g2d.drawString(score, GameMain.width / 2 - metric.stringWidth(GameMain.highscore + "0"), GameMain.height / 2 - metric.getHeight());
        if (GameMain.highscore == 0) {
            g2d.drawString("High Score: " + (GameMain.score / 10) + "0",
                    GameMain.width / 2 - metric.stringWidth(GameMain.highscore + "0"), GameMain.height / 2 - metric.getHeight() * 3);
        } else {
            g2d.drawString("High Score: " + (GameMain.highscore / 10) + "0",
                    GameMain.width / 2 - metric.stringWidth(GameMain.highscore + "0"), GameMain.height / 2 - metric.getHeight() * 3);
        }
    }

    private void renderNewGame(Graphics g2d) {
        myFont = new Font("It wasn't me", Font.BOLD, 100);
        metric = getFontMetrics(myFont);
        g2d.setColor(Color.WHITE);
        g2d.setFont(myFont);
        String title = "Impossible Game";
        g2d.drawString(title, GameMain.width / 2 - metric.stringWidth(title) / 2, GameMain.height / 2);
        int oldFontHeight = metric.getHeight();
        myFont = new Font("It wasn't me", Font.BOLD, 60);
        metric = getFontMetrics(myFont);
        g2d.setFont(myFont);
        g2d.drawString("Press A to play!", GameMain.width / 2 - metric.stringWidth("Press A to play!") / 2, GameMain.height / 2 + oldFontHeight * 2);
    }

    private void renderScore(Graphics g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(myFont);
        score = "" + (GameMain.score / 10) + "0";
        textWidth = metric.stringWidth(score);
        g2d.drawString(score, GameMain.width - textWidth - 10, 50);
        if (GameMain.highscore == 0) {
            g2d.drawString("0", 10, 50);
        } else {
            g2d.drawString("" + (GameMain.highscore / 10) + "0", 10, 50);
        }
    }

    private void renderStars(Graphics g2d) {
        g2d.setColor(Color.YELLOW);
        HashMap<Integer, ArrayList<Integer>> replica = new HashMap();
        for (Integer x : stars.keySet()) {
            for (Integer y : stars.get(x)) {
                g2d.fillRect(x, y, random.nextInt(2) + 3, random.nextInt(2) + 2);
            }
            if (!gameIsPaused) {
                if (x - 1 > 0) {
                    replica.put(x - 1, stars.get(x));
                } else {
                    replica.put(GameMain.width, createStars(stars.get(x).size()));
                }
            }
        }
        if (!gameIsPaused) {
            stars = replica;
        }
    }

    private ArrayList createStars(int amount) {
        ArrayList<Integer> lista = new ArrayList();
        int tahtia = random.nextInt(amount) + 1;
        for (int i = tahtia; i > 0; i--) {
            lista.add(random.nextInt(GameMain.height));
        }
        return lista;
    }
}
