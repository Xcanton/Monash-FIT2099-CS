package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import game.time.TimePerception;

public class Tree extends SpawningGround implements TimePerception {

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('T',15,15);
        this.addCapability(Element.GRASS);
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
