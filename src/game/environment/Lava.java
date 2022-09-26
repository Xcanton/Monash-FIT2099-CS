package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Tools;
import game.time.TimePerceptionManager;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Lava extends Ground {
    /**
     * Constructor.
     */
    public Lava() {
        super('^');
        this.addCapability(Element.FIRE);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        switch (TimePerceptionManager.getTime()){
            case DAY:
                if (Tools.chanceSimulation(10)){
                    Tools.expand(location,this);
                }
                break;
            case NIGHT:
                if (Tools.chanceSimulation(10)) {
                if (!Tools.isActorAt(location)) {
                    this.setDisplayChar('.');
                }
            }
        }

    }
}
