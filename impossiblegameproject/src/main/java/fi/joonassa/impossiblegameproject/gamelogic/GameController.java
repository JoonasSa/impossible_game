package fi.joonassa.impossiblegameproject.gamelogic;

import fi.joonassa.impossiblegameproject.gui.PaintComponent;

public class GameController {

    //tänne tulee muutama controlleri lisää
    private ActorController actorController;
    private PaintComponent paintComponent;

    public GameController() {
        actorController = new ActorController();
        paintComponent = new PaintComponent();
    }

    public void updateGame() {
        actorController.updateObjects();
    }
    
    public void repaint() {
        paintComponent.repaint(actorController.getObjects(), actorController.getPlayer());
    }
    
    public void addActor(int y) {
        actorController.addObject(y);
    }
}
