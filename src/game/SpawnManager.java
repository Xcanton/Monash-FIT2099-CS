package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;


public class SpawnManager {
    private static GameMap gameMap;
    public SpawnManager(GameMap gameMap){
        this.gameMap=gameMap;
    }
    public static void spawnActor(Location location, Actor actor){
        gameMap.at(location.x(), location.y()).addActor(actor);

    }
    public static void spawnItem(Location location, Item item){
        gameMap.at(location.x(), location.y()).addItem(item);
    }

}
