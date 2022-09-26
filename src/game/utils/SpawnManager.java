package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * SpawnManager is a class used to place an object on the gamemap
 */
public class SpawnManager {
    private static GameMap gameMap;
    public SpawnManager(GameMap gameMap){
        this.gameMap=gameMap;

/**
 * Spawn actor is a method used to place newly created actors on the map
  */
    }
    public static void spawnActor(Location location, Actor actor){
        gameMap.at(location.x(), location.y()).addActor(actor);

    }

    /**
     * Spawn item is a method used to place the newly created item on the map
     * @param location the location at which the item is to be placed
     * @param item the item that needs to be placed
     */
    public static void spawnItem(Location location, Item item){
        gameMap.at(location.x(), location.y()).addItem(item);
    }

}
