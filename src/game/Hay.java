package game;

import edu.monash.fit2099.engine.positions.Ground;

public class Hay extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Hay(char displayChar) {
        super(',');
        this.addCapability(Element.GRASS);
    }
}
