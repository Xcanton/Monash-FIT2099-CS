package game.environment;

import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Spawn;
import game.items.Pokefruit;
import game.Tools;

public class Waterfall extends SpawningGround {

    /**
     * Constructor.
     *
     */
    public Waterfall() {
        super('W',20,20);
        this.addCapability(Element.WATER);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        if (Tools.chanceSimulation(20) && Tools.checkGroundSurroundings(Element.WATER,location)) {
            this.addCapability(Spawn.SQUIRTLE);
        }
        if (Tools.chanceSimulation(20)) {
            this.addCapability(Spawn.WATERFRUIT);
        }

    }
}
