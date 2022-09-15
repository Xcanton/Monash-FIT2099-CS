package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import game.time.TimePerception;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Lava extends Ground implements TimePerception {
    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
    }

    @Override
    public void dayEffect() {

    }

    @Override
    public void nightEffect() {

    }
}
