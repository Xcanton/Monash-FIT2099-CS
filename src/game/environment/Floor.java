package game.environment;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents the floor inside a building.
 *
 * Created by:
 * @author Chongjie Chen
 *
 */
public class Floor extends Ground {
	public Floor() {
		super('_');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
