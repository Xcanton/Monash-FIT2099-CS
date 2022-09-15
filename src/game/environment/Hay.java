package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import game.time.TimePerceptionManager;

public class Hay extends Ground {
    /**
     * Constructor.
     */
    public Hay() {
        super(',');
        this.addCapability(Element.GRASS);
    }
}
