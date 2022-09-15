package game;

import edu.monash.fit2099.engine.positions.Ground;

public class Waterfall extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Waterfall(char displayChar) {
        super('w');
        this.addCapability(Element.WATER);
    }
}
