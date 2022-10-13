package game.Trainer;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.Catch;
import game.action.EvolvePokemon;
import game.action.FeedPokefruit;
import game.action.PickUp;
import game.behaviours.WanderBehaviour;
import game.time.TimePerceptionManager;
import game.utils.Affection;
import game.utils.AffectionManager;
import game.utils.SpawnManager;
import game.utils.Status;

import java.util.List;
import java.util.Objects;

import static game.utils.Tools.Surrounding;

public class Goh extends Actor {
    private final WanderBehaviour wanderBehaviours;
    private GameMap gameMap;
    private final Menu menu = new Menu();
    private TimePerceptionManager timePerceptionManager= null;
    private SpawnManager spawnManager;
    private AffectionManager affectionManager=null;
    private static Actor caughtPokemon;

    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Goh(String name, char displayChar, int hitPoints,GameMap gameMap) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.IMMUNE);
        this.gameMap=gameMap;
        timePerceptionManager=TimePerceptionManager.getInstance();
        this.spawnManager= new SpawnManager(gameMap);
        this.affectionManager=AffectionManager.getInstance();
        affectionManager.registerTrainer(this);

        this.wanderBehaviours =  new WanderBehaviour();
    }

    /**
     * Constructor.
     *
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Goh(char displayChar, int hitPoints, GameMap gameMap) {
        super("Goh", displayChar, hitPoints);
        this.addCapability(Status.IMMUNE);
        this.gameMap=gameMap;
        this.timePerceptionManager=TimePerceptionManager.getInstance();
        this.spawnManager= new SpawnManager(gameMap);
        this.affectionManager=AffectionManager.getInstance();
        this.affectionManager.registerTrainer(this);

        this.wanderBehaviours =  new WanderBehaviour();
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // Whenever Goh stands on any Item (e.g., Pokefruit), he will pick it up.
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
            if (allow) { return new PickUp(); }
        }

        /*
		Check surrounding related player action list memu
		Old code's implementation can be transferred in here
		 */
        for (Location loca :Surrounding(location)) {
            try {
                Actor temp = gameMap.at(loca.x(), loca.y()).getActor();
                Affection tempAffection = (Affection) temp;
                // Whenever Goh stands next to any Pokemon
                if (temp != null && this.affectionManager.findPokemon(temp) != null) {
                    // and this Pokemon has affection above 50 points towards him, Goh will catch it.
                    if (this.affectionManager.getAffectionPoint(tempAffection) > 50) {
                        return new Catch(loca.x(), loca.y(), gameMap);
                    } else {
                        // he will give a Pokefruit to the corresponding Pokemon (disregarding their elements).
                        if (gameMap.at(loca.x(), loca.y()).getActor()!=null && this.getInventory().size()!=0) {
                            return new FeedPokefruit(loca.x(), loca.y(), gameMap, this.getInventory().get(0));
                        }
                    }
                }
            }catch (ArrayIndexOutOfBoundsException | NullPointerException | ClassCastException ignored) {}
        }

        return this.wanderBehaviours.getAction(this, map);
    }

    public void getCurrentState() {
        String result = "";
        result += this + " | ";
        Location currentLocation = this.gameMap.locationOf(this);
        result += currentLocation.x() + "," + currentLocation.y() + " | ";
        result += "inventory: " + this.getInventory();
        System.out.println(result);
        for (int y : this.gameMap.getYRange()) {
            for (int x : this.gameMap.getXRange()) {
                Actor temp = this.gameMap.getActorAt(new Location(this.gameMap, x, y));
                if (temp != null && affectionManager.findPokemon(temp)!= null){
                    System.out.println(
                            "- " + temp +
//                                        temp.getMaxHp() +
                                    " at " + x + "," + y +
                                    " with " + affectionManager.getAffectionPoint((Affection) temp) + " AP"
                    );
                }
            }
        }
    }
}
