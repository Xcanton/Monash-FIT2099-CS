package game.environment;

import edu.monash.fit2099.engine.positions.Ground;
import game.Element;
import game.time.TimePerception;
import game.Tools;

public class Puddle extends Ground implements TimePerception {
    /**
     * Constructor.
     *
     */
    public Puddle() {
        super('~');
        this.addCapability(Element.WATER);
    }

    @Override
    public void dayEffect() {
        if (Tools.chanceSimulation(10)==true){
            setDisplayChar('.');
        }
    }

    @Override
    public void nightEffect() {

    }
}
