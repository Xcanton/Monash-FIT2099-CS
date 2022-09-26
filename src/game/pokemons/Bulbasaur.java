package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.*;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.VineWhip;
import game.time.TimePerception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:
 *
 * @author Chongjie Chen
 * Modified by:
 */
public class Bulbasaur extends Actor implements TimePerception, Affection {
    //FIXME: Change it to a sorted map (is it TreeMap? HashMap? LinkedHashMap?)
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private IntrinsicWeapon intrinsicWeapon;
    private VineWhip vineWhip;
    /**
     * Constructor.
     */
    public Bulbasaur() {
        super("Bulbasaur", 'b', 100);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.GRASS);
        this.addCapability(Status.CATCHABLE);
        this.addCapability(Status.POKEMON);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new WanderBehaviour());
        this.intrinsicWeapon=new IntrinsicWeapon(10,"tackles");
        this.registerInstance();
        this.vineWhip=new VineWhip();
        this.registerAffection();
    }

    /**
     * @param otherActor the Actor that might perform an action.
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        //FIXME: allow other actor to attack this Charmander (incl. Player). Please check requirement! :)
        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        System.out.print("Bulbasaur"+printHp() + AffectionManager.getInstance().printAffection(this)+ " ");
        if (AffectionManager.getInstance().getAffectionPoint(this)>75){
            this.behaviours.put(3,new FollowBehaviour(map.at(Player.getPlayerX(),Player.getPlayerY()).getActor()));
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * @param isEquipping FIXME: develop a logic to toggle weapon (put a selected weapon to the inventory - used!);
     */
    public void toggleWeapon(boolean isEquipping) {
        if (isEquipping) {
            this.addItemToInventory(vineWhip);
        }
    }


    @Override
    public void dayEffect() {
        hurt(5);
    }

    @Override
    public void nightEffect() {
        heal(5);
    }
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return intrinsicWeapon;
    }
}
