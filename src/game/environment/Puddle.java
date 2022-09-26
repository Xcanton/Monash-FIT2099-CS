package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Element;
import game.Tools;
import game.time.TimePerceptionManager;

import java.util.ArrayList;
import java.util.List;

public class Puddle extends Ground  {
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        switch(TimePerceptionManager.getTime()){
            case DAY:
                if (Tools.chanceSimulation(10)){
                    setDisplayChar('.');
                }
                break;
            case NIGHT:
                if (Tools.chanceSimulation(10)){
                    Tools.expand(location,this);
                }
        }
    }
}
