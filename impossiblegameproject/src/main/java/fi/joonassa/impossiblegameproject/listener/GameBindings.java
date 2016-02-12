
package fi.joonassa.impossiblegameproject.listener;

import fi.joonassa.impossiblegameproject.actors.Player;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameBindings {
    
    private Player player;
    private static final String MOVE_UP = "move up";
    private static int input = JComponent.WHEN_IN_FOCUSED_WINDOW;
    
    public GameBindings(Player p, JPanel panel) {
        player = p;
        panel.getInputMap(input).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);  
        panel.getActionMap().put(MOVE_UP, new MoveAction());
    } 
    
    class MoveAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("test");
            player.moveUp(10);
        } 
    }
}
