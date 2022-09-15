package game;

import edu.monash.fit2099.engine.positions.Ground;

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
