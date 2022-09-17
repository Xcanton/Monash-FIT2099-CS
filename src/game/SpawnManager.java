package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.pokemons.Bulbasaur;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;
import game.time.TimePerceptionManager;

public class SpawnManager {
    private GameMap gameMap=null;
    public SpawnManager(GameMap gameMap){
        this.gameMap=gameMap;
    }
    public void spawn(){
        for (int y : gameMap.getYRange()) {
            for (int x : gameMap.getXRange()) {
                int i;
                if (gameMap.at(x,y).getGround().findCapabilitiesByType(Spawn.class).size()==0){
                    continue;
                }
                for (i=0;i<gameMap.at(x,y).getGround().findCapabilitiesByType(Spawn.class).size();i++);
                switch (gameMap.at(x,y).getGround().findCapabilitiesByType(Spawn.class).get(i-1)){
                    case CHARMANDER:
                        try{
                            Charmander charmander= new Charmander();
                            gameMap.at(x,y).addActor(charmander);
                            break;}
                        catch (IllegalArgumentException e){
                            continue;
                        }

                    case SQUIRTLE:
                        try{
                            Squirtle squirtle= new Squirtle();
                            gameMap.at(x,y).addActor(squirtle);
                            break;
                        }
                        catch (IllegalArgumentException e){
                            continue;
                        }
                    case BULBASAUR:
                        try {
                            Bulbasaur bulbasaur = new Bulbasaur();
                            gameMap.at(x, y).addActor(bulbasaur);
                            break;
                        }
                        catch (IllegalArgumentException e){
                        }
                }

            }
        }
    }

}
