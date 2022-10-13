package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Element;
import game.utils.SpawnManager;
import game.utils.Tools;

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

        System.out.println("fire spread");
        List<Location> functionLocation = Tools.Surrounding(currentLocation);
        for(Location loca : functionLocation){
            try {
                //  it burns the surrounding (8 squares) by dropping a Fire v
                //  Since the request document says dropping a Fire, weapon: Fire Spin drops fires at surrounding locations,
                //  which would cost multiple fire item on the same location, and player got burnt several times.
                //  here we follow the requirement to achieve this function.
                SpawnManager.spawnItem(new Location(currentLocation.map(), loca.x(), loca.y()), new Fire());
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
    }
}
