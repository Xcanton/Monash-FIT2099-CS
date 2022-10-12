package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public abstract class EvolvableActor extends Actor implements Evolvable {

    public int durationBeforeEvolution;
    public Actor nextPokemon;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public EvolvableActor(String name, char displayChar, int hitPoints, Actor nextPokemon, int duration) {
        super(name, displayChar, hitPoints);
        this.durationBeforeEvolution = duration;
        this.nextPokemon = nextPokemon;
    }

    @Override
    public void EvolveUnit(Actor nextActor, GameMap map) {
        Location currentLocation = map.locationOf(this);
        map.removeActor(this);
        map.addActor(this.nextPokemon, currentLocation);
    }

    @Override
    public void Evolve(GameMap map) {
        if (this.durationBeforeEvolution < 0 & Tools.checkOtherActorSurround(this)) {
            System.out.println(this + " evolve to Pokemon: " + this.nextPokemon.toString());
            EvolveUnit(this.nextPokemon, map);
        }
    }
}
