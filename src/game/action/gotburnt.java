package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Element;

public class gotburnt extends Action {
    protected int burntDamage;
    /**
     * Or the command key
     */
    protected String hotKey;

    public gotburnt(int Damage, String hotKey){this.burntDamage=Damage; this.hotKey=hotKey;}
    public gotburnt(int Damage){this.burntDamage=Damage;}

    @Override
    public String execute(Actor actor, GameMap map) {
        if (!actor.capabilitiesList().contains(Element.FIRE)){
            actor.hurt(this.burntDamage);
            return menuDescription(actor);
        }
        return null;
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player moves east"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " got burnt ";
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
