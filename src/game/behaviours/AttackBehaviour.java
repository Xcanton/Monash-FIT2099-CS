package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;
import game.utils.Tools;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Check if the opponent has the immune capability and will attack if they don't have immunity
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
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
