package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Created by:
 *
 * @author Chongjie Chen
 * Modified by:
 */
public class Blaze extends WeaponItem {
    /** REQ1: Evolution
     * Blaze (60 damage/90 hit rate): a fire-element weapon item.
     **/
    public Blaze(){
        super("Blaze", 'z', 60, "burns", 90);
    }
}
