package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;

public class Crater extends SpawningGround {
    /**
     * Constructor.
     *
     */
    public Crater() {

        super('O',10,25);
        this.addCapability(Element.FIRE);
    }
}
