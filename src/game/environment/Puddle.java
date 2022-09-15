package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

public class Puddle extends Ground {
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
    }
}
