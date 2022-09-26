package game;


import edu.monash.fit2099.engine.actors.Actor;

public interface Affection {

    default void registerAffection(){
        AffectionManager.getInstance().registerPokemon( this);
    }
}
