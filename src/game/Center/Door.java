package game.Center;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public class Door extends Item {

    public Location toLocation;

    /***
     * Constructor.
     *  @param name the name of this Item
     *  @param toLoca the next Location if you choose to enter this door
     */
    public Door(String name, Location toLoca) {
        super(name, '=', false);
        this.toLocation = toLoca;

        this.addSampleAction(new EnterAction(this.toLocation, this.toString()));
    }

    public void addSampleAction(Action newAction){
        this.addAction(newAction);
    }

}
