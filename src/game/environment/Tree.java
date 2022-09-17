package game.environment;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Spawn;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.time.TimePerception;
import game.time.Tools;

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

    @Override
    public void tick(Location location) {
        super.tick(location);
        if (Tools.chanceSimulation(15)) {
            this.addCapability(Spawn.BULBASAUR);

        }
        if (Tools.chanceSimulation(15)) {
            Pokefruit pokefruit= new Pokefruit(Element.GRASS);
            new DropItemAction(pokefruit);
        }

    }
}
