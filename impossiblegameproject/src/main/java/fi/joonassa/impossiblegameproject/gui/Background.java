package fi.joonassa.impossiblegameproject.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Image image = null;
        try {
            image = ImageIO.read(new File("/src/main/java/fi/joonassa/impossiblegameproject/gui/starrysky.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
