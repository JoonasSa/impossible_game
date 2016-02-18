
package fi.joonassa.impossiblegameproject.listener;

import fi.joonassa.impossiblegameproject.actors.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
/**
 * Näppäimistönkuuntelija.
 */
public class GameListener implements KeyListener {
    
    private boolean jumped;
    
    /**
     * Luo uuden näppäimistönkuuntelija.
     */
    public GameListener() {
        jumped = false;
    }
    
    /**
     * Palauttaa onko oikeanlainen syöte saatu.
     * @return totuusarvona true mikäli pelaaja tahtoo hypätä
     */
    public boolean getDidPlayerJump() {
        if (jumped) {
            jumped = false;
            return true;
        }
        return false;
    }
    
    /**
     * Kuuntelee näppäimiä ja asettaa player movingUp = true, mikäli painettu näppäin oli 
     * välilyönti tai ylänuoli.
     * @param e painettu näppäin.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (Player.canJump && (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP)) {
            jumped = true;
            //player.jump();
        }
    }

    /**
     * Asettaa player movingUp = false, kun näppäimestä päästetään irti.
     * @param e vapautettu näppäin.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        jumped = false;
        //player.drop();
    }
        
    @Override
    public void keyTyped(KeyEvent e) {
        
    }  
}
