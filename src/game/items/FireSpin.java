package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Element;
import game.utils.SpawnManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:
 *
 * @author Chongjie Chen
 * Modified by:
 */
public class FireSpin extends WeaponItem {
    /** REQ1: Evolution
     * Blaze (60 damage/90 hit rate): a fire-element weapon item.
     **/

    Element element = Element.FIRE;
    public FireSpin(){
        super("Fire Spin", 'f', 70, "Spin", 90);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        int x = currentLocation.x();
        int y = currentLocation.y();

        System.out.print("fire spread");
        List<Location> functionLocation = new ArrayList<>();
        functionLocation.add(new Location(currentLocation.map(), x-1, y));
        functionLocation.add(new Location(currentLocation.map(), x-1, y-1));
        functionLocation.add(new Location(currentLocation.map(), x, y-1));
        functionLocation.add(new Location(currentLocation.map(), x+1, y-1));
        functionLocation.add(new Location(currentLocation.map(), x+1, y));
        functionLocation.add(new Location(currentLocation.map(), x+1, y+1));
        functionLocation.add(new Location(currentLocation.map(), x, y+1));
        functionLocation.add(new Location(currentLocation.map(), x-1, y+1));
        for(Location loca : functionLocation){
            loca.addItem(new Fire());
        }

//        SpawnManager.spawnItem(new Location(currentLocation.map(), x-1, y), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x-1, y-1), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x, y-1), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x+1, y-1), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x+1, y), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x+1, y+1), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x, y+1), fire);
//        SpawnManager.spawnItem(new Location(currentLocation.map(), x-1, y+1), fire);
    }
}
