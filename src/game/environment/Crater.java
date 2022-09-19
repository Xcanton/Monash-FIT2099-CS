package game.environment;

import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Spawn;
import game.SpawnManager;
import game.items.Pokefruit;
import game.Tools;

public class Crater extends SpawningGround  {
    private static SpawnManager spawnManager;
    /**
     * Constructor.
     *
     */
    public Crater() {
        super('O',10,25);
        this.addCapability(Element.FIRE);
    }


    @Override
    public void tick(Location location) {
        super.tick(location);
        if (Tools.chanceSimulation(10) && Tools.checkGroundSurroundings(Element.FIRE,location)) {
            this.addCapability(Spawn.CHARMANDER);

        }
        if (Tools.chanceSimulation(25)) {
            this.addCapability(Spawn.FIREFRUIT);
        }
    }


}
