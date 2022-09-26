package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.environment.Tree;
import game.items.Pokeball;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;
import game.time.TimePerceptionManager;

import java.util.HashMap;
import java.util.Map;

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
	private AffectionManager affectionManager=null;
	private static Actor caughtPokemon;
	private static int xLocation;
	private static int yLocation;
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
		this.affectionManager=AffectionManager.getInstance();
		affectionManager.registerTrainer(this);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		timePerceptionManager.run();
		Location location=map.locationOf(this);
		if (map.at(location.x(),location.y()).getItems().size()!=0)
		{
			actions.add(new PickUp());
		}
		boolean returnPokemon= Player.getPokemon() != null;

		try {
			if (gameMap.at(location.x() + 1, location.y()).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x() + 1, location.y(), gameMap));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
			try{
			 if (returnPokemon){
				actions.add(new ReturnPokemon(location.x()+1,location.y(),gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
			}
		try {
			if (gameMap.at(location.x() + 1, location.y()).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() + 1, location.y(), gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}


		try {
			if (gameMap.at(location.x() + 1, location.y() + 1).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x() + 1, location.y() + 1, gameMap));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
		try {if (returnPokemon){
				actions.add(new ReturnPokemon(location.x()+1,location.y()+1,gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}
		}
		catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() + 1, location.y()+1).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() + 1, location.y()+1, gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}


		try {
			if (gameMap.at(location.x(), location.y() + 1).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x(), location.y() + 1,gameMap));
			}}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
		try{ if (returnPokemon){
				actions.add(new ReturnPokemon(location.x(),location.y()+1,gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}
		}
		catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() , location.y()+1).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() , location.y()+1, gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}


		try{ if (gameMap.at(location.x()-1, location.y()+1).getActor().hasCapability(Status.CATCHABLE)){
				actions.add(new Catch(location.x()-1, location.y()+1,gameMap));
			}}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
			try{ if (returnPokemon){
				actions.add(new ReturnPokemon(location.x()-1,location.y()+1,gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}}
		catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() - 1, location.y()+1).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() -1, location.y()+1, gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}




		try {
			if (gameMap.at(location.x() - 1, location.y()).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x() - 1, location.y(),gameMap));
			}}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
			try{ if (returnPokemon){
				actions.add(new ReturnPokemon(location.x()-1,location.y(),gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}}
		catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() - 1, location.y()).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() - 1, location.y(), gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}



		try {
			if (gameMap.at(location.x() - 1, location.y() - 1).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x() - 1, location.y() - 1,gameMap));
			}}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
			try{ if (returnPokemon){
				actions.add(new ReturnPokemon(location.x()-1,location.y()-1,gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}}
		catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() - 1, location.y()-1).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() - 1, location.y()-1, gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}



		try {
			if (gameMap.at(location.x(), location.y() - 1).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x(), location.y() - 1,gameMap));
			}}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		}
			try{ if (returnPokemon){
				actions.add(new ReturnPokemon(location.x(),location.y()-1,gameMap,Player.caughtPokemon));
				returnPokemon=false;
			}}
		catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() , location.y()-1).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() , location.y()-1, gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}



		try {
			if (gameMap.at(location.x() + 1, location.y() - 1).getActor().hasCapability(Status.CATCHABLE)) {
				actions.add(new Catch(location.x() + 1, location.y() - 1,gameMap));
			}}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
		} try{ if (returnPokemon){
					actions.add(new ReturnPokemon(location.x()+1,location.y()-1,gameMap,Player.caughtPokemon));
			}
}			catch (ArrayIndexOutOfBoundsException | NullPointerException ignored){
		}
		try {
			if (gameMap.at(location.x() + 1, location.y()-1).getActor()!=null && this.getInventory().size()!=0) {
				actions.add(new FeedPokefruit(location.x() + 1, location.y()-1, gameMap, this.getInventory().get(0) ));
			}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}

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

	public static void registerPokemon(Pokeball pokeball){
		caughtPokemon=pokeball.getActor();
	}
	public static void removePokemon(){
		caughtPokemon=null;
	}
	public static Actor getPokemon(){
		return Player.caughtPokemon;
	}
	public void setLocation(int x, int y){
		xLocation=x;
		yLocation=y;
	}
	public static int getPlayerX(){
		return xLocation;
	}
	public static int getPlayerY(){
		return yLocation;
	}
}
