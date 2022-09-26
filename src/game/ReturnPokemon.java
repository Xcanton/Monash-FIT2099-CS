package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ReturnPokemon extends Action {
    Actor pokemon;
    int xLocation;
    int yLocation;
    public ReturnPokemon(int x, int y,GameMap map,Actor pokemon) {
        super();
        this.xLocation=x;
        this.yLocation=y;
        this.pokemon=pokemon;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        Player.removePokemon();
        map.addActor(pokemon,map.at(xLocation,yLocation));
        return "I choose you... "+ pokemon+" !";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Return " +pokemon + " onto the field";
    }
}
