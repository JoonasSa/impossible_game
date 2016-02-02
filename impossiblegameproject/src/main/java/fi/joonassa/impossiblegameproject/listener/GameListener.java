
package fi.joonassa.impossiblegameproject.listener;

import fi.joonassa.impossiblegameproject.actors.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class GameListener implements KeyListener {
    
    private Player player;
    
    public GameListener(Player player) {
        this.player = player;
    }

    //tulee toimia todennäköisesti pressed -> released logiikalla
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp(10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
        
    @Override
    public void keyTyped(KeyEvent e) {
        
    }  
}
