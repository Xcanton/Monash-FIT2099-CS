package game.utils;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.action.*;
import game.items.Pokeball;
import game.time.TimePerceptionManager;

import java.util.List;
import java.util.Objects;

import static game.utils.Tools.Surrounding;

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

	/**
	 * Play turn is called every turn and checks to see the possible actions an actor can take.
	 * Try catch loops check to see if conditions are met. If conditions are met, then a new action corresponding to that action will become selectable on the IO
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		timePerceptionManager.run();
		Location location=map.locationOf(this);

		List<Item> items = map.at(location.x(),location.y()).getItems();
		if (items.size()!=0)
		{
			boolean allow = true;
			for (Item item : items){
				if (Objects.isNull(item.getPickUpAction(this))){
					allow = false;
					break;
				}
			}
			if (allow) { actions.add(new PickUp()); }
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

		/*
		Check surrounding related player action list memu
		Old code's implementation can be transferred in here
		 */
		for (Location loca :Surrounding(location)) {
			try {
				Actor temp = gameMap.at(loca.x(), loca.y()).getActor();
				Affection tempAffection = (Affection) temp;
				if (Objects.nonNull(temp) && this.affectionManager.getAffedtion(tempAffection) >=100) {
					actions.add(new EvolvePokemon(loca.x(), loca.y(), gameMap));
				}
			}catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {}
		}

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

	/**
	 * register the pokemon in a pokeball
	 * @param pokeball
	 */
	public static void registerPokemon(Pokeball pokeball){
		caughtPokemon=pokeball.getActor();
	}

	/**
	 * remove pokemonfrom the pokeball
	 */
	public static void removePokemon(){
		caughtPokemon=null;
	}

	/**
	 * Get the pokemon instance inside the pokeball
	 * @return
	 */
	public static Actor getPokemon(){
		return Player.caughtPokemon;
	}

	/**
	 * Set the players location
	 * @param x the x coordinate of the player
	 * @param y the y coordinate of the player
	 */
	public void setLocation(int x, int y){
		xLocation=x;
		yLocation=y;
	}

	/**
	 * Get the player's x coordinate
	 * @return
	 */
	public static int getPlayerX(){
		return xLocation;
	}

	/**
	 * get the player's y coordinate
	 * @return
	 */
	public static int getPlayerY(){
		return yLocation;
	}
}
