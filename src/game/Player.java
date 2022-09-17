package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.environment.Tree;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;
import game.time.TimePerceptionManager;

/**
 * Class representing the Player.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Player extends Actor {
	private GameMap gameMap;
	private final Menu menu = new Menu();
	private TimePerceptionManager timePerceptionManager= null;
	private SpawnManager spawnManager;
	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints,GameMap gameMap) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.IMMUNE);
		this.gameMap=gameMap;
		timePerceptionManager=TimePerceptionManager.getInstance();
		this.spawnManager= new SpawnManager(gameMap);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		timePerceptionManager.run();
		spawnManager.spawn();

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();


		// return/print the console menu
		return menu.showMenu(this, actions, display);

	}

	@Override
	public char getDisplayChar() {
		return super.getDisplayChar();
	}
}
