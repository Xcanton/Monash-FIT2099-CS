package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Affection;
import game.utils.AffectionManager;
import game.utils.Element;
import game.utils.EvolvableActor;

import java.util.List;

public class EvolvePokemon extends Action {
    int xLocation;
    int yLocation;
    Actor target;
    Affection instance;

    public EvolvePokemon(int x, int y, GameMap gameMap) {
        super();
        this.xLocation=x;
        this.yLocation=y;
        this.target=gameMap.at(xLocation,yLocation).getActor();
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        instance= AffectionManager.getInstance().findPokemon(target);
        if (AffectionManager.getInstance().getAffedtion(instance) >=100 | instance instanceof EvolvableActor) {
            EvolvableActor pokemon = (EvolvableActor) instance;
            System.out.println(instance + " got 100 AP, and it evolves into " + pokemon.nextPokemon);
            pokemon.EvolveUnit(map);
        }

        return "";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Trainer " + "Ash " + "trigger evolution of "+ target;
    }
}
