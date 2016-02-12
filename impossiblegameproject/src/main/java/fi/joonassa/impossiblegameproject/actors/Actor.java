package fi.joonassa.impossiblegameproject.actors;

/**
 * Yläluokka kaikille ruudun liikkuville olioille.
 */
public class Actor {

    private int x;
    private int y;
    private int width;
    private int height;

    public Actor(int x, int y, int width, int height) {
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (width < 0) {
            width = 10;
        }
        if (height < 0) {
            height = 10;
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y >= 0) {
            this.y = y;
        }
    }
    
    /**
     * Liikkuttaa actoria vasemmalle (-x) parametrin verran.
     * @param amount paljon liikutaan vasemmalle.
     */
    public void moveLeft(int amount) {
        if (amount >= 0) {
            x -= amount;
        }
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
