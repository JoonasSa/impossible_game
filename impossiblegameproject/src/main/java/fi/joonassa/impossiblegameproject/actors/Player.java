
package fi.joonassa.impossiblegameproject.actors;

/**
 * Pelaajan logiikka luokka.
 */
public class Player extends Actor {

    /**
     * Määrittelee mihin suuntaan pelaaja liikku pelin päivittyessä.
     */
    public static boolean movedUp;
    
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        movedUp = false;
    }
    
    //tee static final ruudun mitat, jotta voit varmistaa ettei liikuta ulos ruudusta
    /**
     * Liikkuttaa actoria todellisuudessa alas ruudulla (y) parametrin verran.
     * Huomaa että ikkunan y koordinaatti on "väärinpäin".
     * @param amount liikutettava määrä.
     */
    public void moveDown(int amount) {
        if (amount >= 0) {
            this.setY(this.getY() + amount);
        }
    }
    
    /**
     * Liikkuttaa actoria todellisuudessa ylös ruudulla (-y) parametrin verran.
     * Huomaa että ikkunan y koordinaatti on "väärinpäin".
     * @param amount liikutettava määrä.
     */
    public void moveUp(int amount) {
        if (amount >= 0) {
            this.setY(this.getY() - amount);
        }
    }    
}
