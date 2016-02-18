
package fi.joonassa.impossiblegameproject.actors;

/**
 * Alustojen logiikka luokka.
 */
public class Platform extends Actor {
    
    /**
     * Luo uuden alustan peliin.
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param width leveys
     * @param height korkeus
     */
    public Platform(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
