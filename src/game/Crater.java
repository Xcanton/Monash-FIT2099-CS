package game;

import edu.monash.fit2099.engine.positions.Ground;

public class Crater extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Crater(char displayChar) {
        super('o');
        this.addCapability(Element.FIRE);
    }
}
