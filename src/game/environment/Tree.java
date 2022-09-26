package game.environment;

import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Spawn;
import game.SpawnManager;
import game.items.Candy;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.time.TimePerception;
import game.Tools;
import game.time.TimePerceptionManager;

import java.util.ArrayList;

public class Tree extends SpawningGround  {

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('T',15,15);
        this.addCapability(Element.GRASS);

    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        try {
            if (Tools.chanceSimulation(15) && Tools.checkGroundSurroundings(Element.GRASS, location, 1)) {
                Bulbasaur bulbasaur = new Bulbasaur();
                SpawnManager.spawnActor(location, bulbasaur);
            }
            if (Tools.chanceSimulation(15)) {
                Pokefruit pokefruit = new Pokefruit(Element.GRASS);
                SpawnManager.spawnItem(location, pokefruit);
            }
        }
        catch (IllegalArgumentException ignored){

        }
        switch (TimePerceptionManager.getTime()){
            case DAY:
                if (Tools.chanceSimulation(5)){
                    Candy candy=new Candy();
                    SpawnManager.spawnItem(location,candy);
                }
                break;
            case NIGHT:
                if (Tools.chanceSimulation(10)){
                    if (Tools.chanceSimulation(50)){
                        Hay hay= new Hay();
                        Tools.expand(location,hay);
                    }
                    else Tools.expand(location,this);
                }
        }

    }
}
