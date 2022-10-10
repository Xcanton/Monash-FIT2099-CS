package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.items.Ember;
import game.items.Blaze;
import game.time.TimePerception;
import game.utils.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:
 *
 * @author Chongjie Chen
 * Modified by: Chongjie Chen
 */
public class Charmeleon extends Actor implements TimePerception, Affection {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private IntrinsicWeapon intrinsicWeapon;
    private Ember ember;
    private Blaze blaze;
    /**
     * Constructor.
     */
    public Charmeleon() {
        // REQ1: Evolution
        // Charmeleon C (capital C) has a maximum of 150 HP
        super("Charmeleon", 'C', 150);
        // REQ1: Evolution
        // HINT: add more relevant behaviours here
        // Fire-Type
        this.addCapability(Element.FIRE);
        this.addCapability(Status.POKEMON);
        this.behaviours.put(1, new AttackBehaviour());
        // REQ1: Evolution
        // Scratch (intrinsic attack): refer to Assignment 1 & 2 requirements
        this.intrinsicWeapon=new IntrinsicWeapon(10,"scratches");
        // REQ1: Evolution
        // Ember: refer to Assignment 1 & 2 requirements
        this.ember= new Ember();
        // REQ1: Evolution
        // Blaze (60 damage/90 hit rate): a fire-element weapon item.
        this.blaze= new Blaze();
        this.registerInstance();
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
        return actions;
    }

    /**
     * By using behaviour loops, it will decide what will be the next action automatically.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        System.out.print("Charmander"+printHp() + AffectionManager.getInstance().printAffection(this)+" ");
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

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return intrinsicWeapon;
    }

    /** REQ1: Evolution
     * Not Affected by Day
     **/
    @Override
    public void dayEffect() {

    }

    /** REQ1: Evolution
     * Not Affected by Night
     **/
    @Override
    public void nightEffect() {

    }
}
