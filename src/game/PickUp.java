package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class PickUp extends Action {
    Item item;


    @Override
    public String execute(Actor actor, GameMap map) {
        item=map.at(map.locationOf(actor).x(),map.locationOf(actor).y()).getItems().get(0);
        actor.addItemToInventory(item);
        return "Ash has picked up "+ item;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Ash picks up " + item;
    }
}
