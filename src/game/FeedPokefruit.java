package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

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

    @Override
    public String execute(Actor actor, GameMap map) {
        instance=AffectionManager.getInstance().findPokemon(target);
        Element itemElement=this.item.findCapabilitiesByType(Element.class).get(0);
        System.out.println("Ash gives a " + itemElement+" Pokefruit" +" to " +target+""+AffectionManager.getInstance().printAffection(instance));
        if(target.findCapabilitiesByType(Element.class).get(0)==itemElement){
            AffectionManager.getInstance().increaseAffection(instance,20);}
        else {AffectionManager.getInstance().decreaseAffection(instance,10);}
        actor.removeItemFromInventory(item);
        return "";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Feed Pokefruit to "+ target;
    }
}
