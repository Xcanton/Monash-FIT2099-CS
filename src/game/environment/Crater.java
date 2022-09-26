package game.environment;

import edu.monash.fit2099.engine.positions.Location;
import game.items.Pokefruit;
import game.pokemons.Charmander;
import game.utils.Element;
import game.utils.SpawnManager;
import game.utils.Tools;
/**
 * Crater
 * <p>
 * Class that represents a crater
 * @author Chongjie Chen
 */
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

    /**
     * Overide method to check the ground and spawn a new pokemon
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        try {
            if (Tools.chanceSimulation(10) && Tools.checkGroundSurroundings(Element.FIRE, location, 0)) {
                Charmander charmander = new Charmander();

                SpawnManager.spawnActor(location, charmander);
            }
            if (Tools.chanceSimulation(25)) {
                Pokefruit pokefruit = new Pokefruit(Element.FIRE);
                SpawnManager.spawnItem(location, pokefruit);
            }
        }
        catch (IllegalArgumentException ignored){}
    }


}
