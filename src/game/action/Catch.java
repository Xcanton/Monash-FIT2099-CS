package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Affection;
import game.utils.AffectionManager;
import game.utils.Player;
import game.items.Candy;
import game.items.Pokeball;
/**
 * Catch
 * <p>
 * Catch is a class which catches the pokemon and stores it in a pokeball
 * @author Chongjie Chen
 */

public class Catch extends Action {
    int xLocation;
    int yLocation;
    Actor target;
    public Catch(int x, int y,GameMap map) {
        super();
        this.xLocation=x;
        this.yLocation=y;
        this.target=map.at(xLocation,yLocation).getActor();
    }

    /**
     * execute is a method that checks the affection of a pokemon and takes appropriate action if requirements not met.
     * If requirements are met, then it will capture the pokemon
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Affection pokemon= AffectionManager.getInstance().findPokemon(map.at(xLocation,yLocation).getActor());
        if (AffectionManager.getInstance().getAffectionPoint(pokemon)<50)
            AffectionManager.getInstance().decreaseAffection(pokemon,10);
        else if (Player.getPokemon()==null)
            {
                Pokeball pokeball=new Pokeball();
                pokeball.catchPokemon(map.at(xLocation,yLocation).getActor());
                map.removeActor(map.at(xLocation,yLocation).getActor());
                Player.registerPokemon(pokeball);
                Candy candy= new Candy();
                map.at(xLocation,yLocation).addItem(candy);
                return "Ash has caught "+ pokeball.getActor();
            }
        return "Pokemon catch was unsuccessful";
    }

    /**
     * Menu description of what will appear on the menu
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Ash catches " + target;
    }
}
