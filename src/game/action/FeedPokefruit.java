package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Affection;
import game.utils.AffectionManager;
import game.utils.Element;

import java.util.List;

/**
 * FeedPokefruit
 * <p>
 * Class which feeds the pokefruit to a pokemon
 * @author Chongjie Chen
 */
public class FeedPokefruit extends Action {
    int xLocation;
    int yLocation;
    Item item;
    Actor target;
    Affection instance;
    public FeedPokefruit(int x, int y, GameMap gameMap, Item item) {
        super();
        this.item=item;
        this.xLocation=x;
        this.yLocation=y;
        this.target=gameMap.at(xLocation,yLocation).getActor();
    }

    /**
     * Action method which is called every turn. When called it will feed the pokefruit to the pokemon and remove it from the actor's inventory
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        instance= AffectionManager.getInstance().findPokemon(target);

        List<Element> itemElements = this.item.findCapabilitiesByType(Element.class);
        if (!itemElements.isEmpty()) {
            Element itemElement = itemElements.get(0);
            System.out.println("Ash gives a " + itemElement + " Pokefruit" + " to " + target + "" + AffectionManager.getInstance().printAffection(instance));

            // speed up testing : giving a fruit will increase AP by 100
             if (target.findCapabilitiesByType(Element.class).get(0) == itemElement) {
                AffectionManager.getInstance().increaseAffection(instance, 100);  // 20
            } else {
                AffectionManager.getInstance().decreaseAffection(instance, 10);
            }
            actor.removeItemFromInventory(item);
        }
        return "";
    }

    /**
     * Menu description of action
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Feed Pokefruit to "+ target;
    }
}
