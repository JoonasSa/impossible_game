
package fi.joonassa.impossiblegameproject.listener;

import fi.joonassa.impossiblegameproject.actors.Player;
import fi.joonassa.impossiblegameproject.gamemain.GameMain;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
/**
 * Näppäimistönkuuntelija.
 */
public class GameListener implements KeyListener {
    
    private boolean jumped;
    private boolean restart;
    private boolean paused;
    
    /**
     * Luo uuden näppäimistönkuuntelija.
     */
    public GameListener() {
        jumped = false;
        restart = false;
        paused = false;
    }
    
    /**
     * Palauttaa onko oikeanlainen syöte saatu.
     * @return totuusarvona true mikäli pelaaja tahtoo hypätä
     */
    public boolean getDidPlayerJump() {
        return jumped;
    }
    
    public boolean getDidPlayerRestart() {
        if (restart) {
            restart = false;
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
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            restart = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            GameMain.gamePaused = !GameMain.gamePaused;
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
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
