package game.environment;

import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Spawn;
import game.SpawnManager;
import game.items.Pokefruit;
import game.pokemons.Charmander;
import game.time.Tools;

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
        if (Tools.chanceSimulation(10)) {
            this.addCapability(Spawn.CHARMANDER);
        }
        if (Tools.chanceSimulation(25)) {
            Pokefruit pokefruit= new Pokefruit(Element.FIRE);
            new DropItemAction(pokefruit);
        }
    }


}
