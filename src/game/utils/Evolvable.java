package game.utils;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Created by:
 * @author Chongjie Chen
 * Modified by:
 *
 * implementors have to be behaviors related to pokemons evolvement,
 * implementing this interface allow map to change origin pokemon into new pokemon
 */
public interface Evolvable {
//    public static Actor NEXTPOKEMON;  // interface can only have final variables

    void Evolve(GameMap map);

    void EvolveUnit(GameMap map);
}
