package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class Pokeball extends Item {
Actor actor=null;
    public Pokeball() {
        super("Pokeball", '0', true);
    }
    public void catchPokemon(Actor actor1){
        if (actor==null){
            actor=actor1;
        }
    }
    public Actor getActor(){
        return this.actor;
    }
}
