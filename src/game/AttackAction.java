package game;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.items.Bubble;
import game.items.Ember;
import game.items.VineWhip;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;

/**
 * An Action to attack another Actor.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        try {
            switch (actor.findCapabilitiesByType(Element.class).get(0)) {
                case FIRE:
                    if (Tools.checkGround(actor, map.locationOf(actor))) {
                        Ember ember = new Ember();
                        actor.addItemToInventory(ember);
                    }
                    break;

                case GRASS:
                    if (Tools.checkGround(actor, map.locationOf(actor))) {
                        VineWhip vineWhip = new VineWhip();
                        actor.addItemToInventory(vineWhip);
                    }
                    break;

                case WATER:
                    if (Tools.checkGround(actor, map.locationOf(actor)) || target.hasCapability(Element.FIRE)) {
                        Bubble bubble = new Bubble();
                        actor.addItemToInventory(bubble);
                    }
                    break;
            }
        }catch (NullPointerException e){}
        Weapon weapon = actor.getWeapon();

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);

        if (actor.findCapabilitiesByType(Status.class).contains(Status.POKEMON))
        {
            int i;
            for (i=0;i<actor.getInventory().size();i++)
                actor.removeItemFromInventory(actor.getInventory().get(i));
        }
        if (!target.isConscious()) {
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + target + " is killed.";
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction;
    }
}
