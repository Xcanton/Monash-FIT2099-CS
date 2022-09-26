package game.environment;

import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Spawn;
import game.SpawnManager;
import game.items.Pokefruit;
import game.Tools;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;

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
        try {
            if (Tools.chanceSimulation(20) && Tools.checkGroundSurroundings(Element.WATER, location, 2)) {
                Squirtle squirtle = new Squirtle();
                SpawnManager.spawnActor(location, squirtle);
            }
            if (Tools.chanceSimulation(20)) {
                Pokefruit pokefruit = new Pokefruit(Element.WATER);
                SpawnManager.spawnItem(location, pokefruit);
            }
        }
        catch (IllegalArgumentException ignored){
        }

    }
}
