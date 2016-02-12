
package fi.joonassa.impossiblegameproject.listener;

import fi.joonassa.impossiblegameproject.actors.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
/**
 * Näppäimistönkuuntelija.
 */
public class GameListener implements KeyListener {
    
    private Player player;
    
    //ilmeisesti turha antaa player tänne
    public GameListener(Player player) {
        this.player = player;
    }
    
    //tulee toimia todennäköisesti pressed -> released logiikalla
    /**
     * Kuuntelee näppäimiä ja asettaa player movedUp = true, mikäli näppäin oli 
     * välilyönti tai ylänuoli.
     * @param e painettu näppäin.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            Player.movedUp = true;
        }
    }

    /**
     * Asettaa player movedUP = false, kun näppäimestä päästetään irti.
     * @param e vapautettu näppäin.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        Player.movedUp = false;
    }
        
    @Override
    public void keyTyped(KeyEvent e) {
        
    }  
}
