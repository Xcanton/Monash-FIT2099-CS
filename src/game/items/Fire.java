package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.gotburnt;
import game.utils.AffectionManager;
import game.utils.Element;

import java.util.Objects;

/**
 * Created by:
 *
 * @author Chongjie Chen
 * Modified by:
 */
public class Fire extends WeaponItem {
    /** REQ1: Evolution
     * A Fire v in�icts 10 damage to a non-Fire type Pokemons per turn
     * and stays on the ground for the next two turns.
     **/

    Element element = Element.FIRE;
    /**
     * Turns that this item staies on the ground.
     **/
    private int existTicksCount = 2;
    public Fire(){
        super("Fire", 'v', 10, "burns", 100);
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        this.existTicksCount--;
        // Vanish
        if(this.existTicksCount < 0) {
            currentLocation.removeItem(this);
        } else {
            Actor currentActor = currentLocation.getActor();
            try {
                Objects.requireNonNull(currentActor);
                System.out.println( currentActor.toString() + " got burnt for 10 damage. ");
                currentActor.hurt(10);
            } catch (NullPointerException ignored) {

            }
        }
    }
}
