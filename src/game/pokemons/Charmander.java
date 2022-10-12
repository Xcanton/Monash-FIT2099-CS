package game.pokemons;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.items.Ember;
import game.time.TimePerception;
import game.utils.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Chongjie Chen
 */
public class Charmander extends EvolvableActor implements TimePerception, Affection {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour
    private IntrinsicWeapon intrinsicWeapon;
    private Ember ember;
    /**
     * Constructor.
     */
    public Charmander() {
        super("Charmander", 'c', 100, new Charmeleon(), 20);
        // HINT: add more relevant behaviours here
        this.addCapability(Element.FIRE);
        this.addCapability(Status.POKEMON);
        this.behaviours.put(1, new AttackBehaviour());
        this.intrinsicWeapon=new IntrinsicWeapon(10,"scratches");
        this.ember= new Ember();
        this.addItemToInventory(this.ember);
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

        durationBeforeEvolution--;
        Evolve(map);

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
    public void dayEffect() {
        heal(10);
    }

    @Override
    public void nightEffect() {
        hurt(10);
    }
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return intrinsicWeapon;
    }

}
