package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

public class Tree extends SpawningGround {

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+',15,15);
        this.addCapability(Element.GRASS);
    }
}
