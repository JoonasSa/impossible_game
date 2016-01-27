package fi.joonassa.impossiblegameproject.actors;

public class Actor {

    private int x;
    private int y;

    public Actor(int x, int y) {
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        this.x = x;
        this.y = y;
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
        
    public void moveLeft(int amount) {
        if (amount >= 0) {
            x -= amount;
        }
    }
    
    /*
    public boolean isPositive(int i) {
        return i >= 0;
    }
    */
}
