package game.Trainer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.AffectionManager;

public class DisplayTrainerStateAction extends Action {

    protected String hotKey;
    private AffectionManager affectionManager;

    public DisplayTrainerStateAction(String hotKey) {
        this.hotKey = hotKey;
    }

    public DisplayTrainerStateAction(AffectionManager affectionManager) {
        this.hotKey = "z";
        this.affectionManager = affectionManager;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        result += actor + " | ";
        Location currentLocation = map.locationOf(actor);
        result += currentLocation.x() + "," + currentLocation.y() + " | ";
        result += "inventory: " + actor.getInventory();
        System.out.println(result);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Show " + actor + " ";
    }
}
