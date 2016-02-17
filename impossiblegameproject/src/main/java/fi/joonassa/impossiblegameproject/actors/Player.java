
package fi.joonassa.impossiblegameproject.actors;

/**
 * Pelaajan logiikka luokka.
 */
public class Player extends Actor {

    /**
     * Määrittelee mihin suuntaan pelaaja liikku pelin päivittyessä.
     */
    public static boolean movingUp;
    public static boolean canJump;
    private double speed;
    private double gravity;
    
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        //alustetaan drop tilaan
        movingUp = false;
        speed = 1;
        gravity = 1.02;
        canJump = false;
    }
    
    public void parseInput(boolean jumped) {
        if (!movingUp && canJump && jumped) {
            jump();
        }
    }
    
    public void jump() {
        movingUp = true;
        speed = 10;
        gravity = 0.98;
    }
    
    public void updateJump() {
        speed *= gravity;
        //hypyn yläkohta
        if (movingUp && speed <= 1) {
            drop();
        } else if (!movingUp && speed >= 10) {
            gravity = 1;
        }
    }
    
    public void drop() {
        movingUp = false;
        speed = 1.2;
        gravity = 1.02;
    }
    
    public int getJumpSpeed() {
        return (int) speed;
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
