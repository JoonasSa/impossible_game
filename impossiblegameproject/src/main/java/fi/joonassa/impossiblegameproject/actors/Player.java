
package fi.joonassa.impossiblegameproject.actors;

public class Player extends Actor {

    public Player(int x, int y) {
        super(x, y);
    }   
    //tee static final ruudun mitat, jotta voit varmistaa ettei liikuta ulos ruudusta
    //ehkä siirretään eri movet actorille
    public void moveUp(int amount) {
        if (amount >= 0) {
            this.setY(this.getY() + amount);
        }
    }
    
    public void moveDown(int amount) {
        if (amount >= 0) {
            this.setY(this.getY() - amount);
        }
    }    
}
