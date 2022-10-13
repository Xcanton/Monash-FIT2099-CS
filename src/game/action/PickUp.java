package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
/**
 * PickUp
 * <p>
 * Pick up is a class which picks up an item off the ground
 * @author Chongjie Chen
 */
public class PickUp extends Action {
    Item item;

    /**
     * Action that is called to pick up an item on the ground.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        item=map.at(map.locationOf(actor).x(),map.locationOf(actor).y()).getItems().get(0);
        actor.addItemToInventory(item);
        return actor + " has picked up "+ item;
    }

    /**
     * Menu description of action
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up " + item;
    }
}
