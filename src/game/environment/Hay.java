package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Element;
/**
 * Hay
 * <p>
 *
 * @author Chongjie Chen
 */

public class Hay extends Ground {
    /**
     * Constructor.
     */
    public Hay() {
        super(',');
        this.addCapability(Element.GRASS);
    }
}
