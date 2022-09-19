package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.*;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {

    /**
     *  HINT: develop a logic to check surrounding, check elements, and return an action to attack that opponent.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Actor otherActor = Tools.checkActorSurroundings(actor, map.locationOf(actor));
        if(otherActor!=null && !otherActor.hasCapability(Status.IMMUNE)){
            return new AttackAction(otherActor, "here"); // behaviour will stop here.
        }
        return null; // go to next behaviour
    }
}
