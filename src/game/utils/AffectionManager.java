package game.utils;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.HashMap;
import java.util.Map;

/**
 * Affection Manager
 * <p>
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class AffectionManager {

    /**
     * Singleton instance (the one and only for a whole game).
     */
    private static AffectionManager instance;
    /**
     * Hash map which maps the actors and affection
     */
    private final Map<Affection, Integer> affectionPoints;

    /**
     * We assume there's only one trainer in this manager.
     * Think about how will you extend it.
     */
    private Actor trainer;

    /**
     * private singleton constructor
     */
    private AffectionManager() {
        this.affectionPoints = new HashMap<>();
    }

    /**
     * Access single instance publicly
     *
     * @return this instance
     */
    public static AffectionManager getInstance() {
        if (instance == null) {
            instance = new AffectionManager();
        }
        return instance;
    }

    /**
     * Add a trainer to this class's attribute. Assume there's only one trainer at a time.
     *
     * @param trainer the actor instance
     */
    public void registerTrainer(Actor trainer) {
        this.trainer = trainer;
    }

    /**
     * Add Pokemon to the collection. By default, it has 0 affection point. Ideally, you'll register all instantiated Pokemon
     *
     * @param objInstance the actor which implements affection
     */
    public void registerPokemon(Affection objInstance) {
        affectionPoints.put(objInstance,0);
    }

    /**
     * Get the affection point by using the pokemon instance as the key.
     *
     * @param objInstance Pokemon instance that experiences affection
     * @return integer of affection point.
     */
    public int getAffectionPoint(Affection objInstance) {
        return affectionPoints.get(objInstance);
    }

    /**
     * Useful method to search a pokemon by using Actor instance.
     *
     * @param actor general actor instance
     * @return the Pokemon instance.
     */
    public Affection findPokemon(Actor actor) {
        for (Affection pokemon : affectionPoints.keySet()) {
            if (pokemon.equals(actor)) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Increase the affection. Work on both cases when there's a Pokemon,
     * or when it doesn't exist in the collection.
     *
     * @param objInstance Actor instance, but we expect a Pokemon here.
     * @param point positive affection modifier
     * @return custom message to be printed by Display instance later.
     */
    public void increaseAffection(Affection objInstance, int point) {
        int affection=affectionPoints.get(objInstance);
        if (affection+point>100) {
            int difference= 100-affection;
            affectionPoints.put(objInstance, 100);
            System.out.println(objInstance + " likes it! +" + difference + " affection points");
        } else{
            affectionPoints.put(objInstance,affection+point);
            System.out.println(objInstance+" likes it! +" + point +" affection points");
        }
    }

    /**
     * Decrease the affection level of the . Work on both cases when it is
     *
     * @param objInstance Actor instance, but we expect a Pokemon here.
     * @param point positive affection modifier (to be subtracted later)
     * @return custom message to be printed by Display instance later.
     */
    public void decreaseAffection(Affection objInstance, int point) {
        int affection = affectionPoints.get(objInstance);
        if (affection - point < (-50)) {
            int difference = -50 + affection;
            affectionPoints.put(objInstance, -50);
            System.out.println(objInstance + " dislikes it! -" + difference + " affection points");
        } else {
            affectionPoints.put(objInstance, affection - point);
            System.out.println(objInstance + " dislikes it! -" + point + " affection points");
        }
    }

    /**
     * A method which is called upon to print the string
     * @param objInstance
     * @return
     */
    public String printAffection(Affection objInstance){
        return ("(AP: "+this.getAffectionPoint(objInstance))+")";
    }
}
