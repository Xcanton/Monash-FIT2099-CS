package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

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
