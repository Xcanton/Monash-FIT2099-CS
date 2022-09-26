package game.utils;


public interface Affection {

    default void registerAffection(){
        AffectionManager.getInstance().registerPokemon( this);
    }
}
