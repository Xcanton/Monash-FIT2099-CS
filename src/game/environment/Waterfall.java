package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

public class Waterfall extends SpawningGround {

    /**
     * Constructor.
     *
     */
    public Waterfall() {
        super('W',20,20);
        this.addCapability(Element.WATER);
    }
}
