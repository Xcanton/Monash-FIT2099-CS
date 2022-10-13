package game.Center;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class EnterAction extends Action {

    public String otherSide;
    public Location moveToLocation;
    protected String hotKey;

    public EnterAction(Location moveToLocation, String mapName, String hotKey) {
        this.moveToLocation = moveToLocation;
        this.otherSide = mapName;
        this.hotKey = hotKey;
    }

    public EnterAction(Location moveToLocation, String mapName) {
        this.moveToLocation = moveToLocation;
        this.otherSide = mapName;
        this.hotKey = null;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, this.moveToLocation);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Ash enters " + this.otherSide;
    }

    /**
     * Returns this Action's hotkey.
     *
     * @return the hotkey
     */
    @Override
    public String hotkey() {
        return hotKey;
    }
}
