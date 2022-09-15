package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.environment.*;
import game.pokemons.Charmander;
import game.time.TimePerceptionManager;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(),
                new Floor(), new Tree(), new Lava(), new Puddle(),
                new Crater(), new Waterfall(), new Hay(), new Lava());

        TimePerceptionManager timePerceptionManager= null;
        List<String> map = Arrays.asList(
                ".............................................^^^^^^^^^^^^^^",
                "...........,T,................................,T,..^^^^O^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "..........................#######...........,,...........^^",
                "..........................#_____#...........,T............^",
                "..,,,...............,T....#_____#..........................",
                "..,T,......~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~W~~~~.,............................,,,...................",
                "~~~~~~.,T,...........................,T,...................",
                "~~~~~~~~~............................,.....................");
        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);
        timePerceptionManager=TimePerceptionManager.getInstance();

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1);
        world.addPlayer(ash, gameMap.at(32, 10));

        //Add first pokemon - Charmander
        Actor charmander = new Charmander();
        gameMap.at(33, 10).addActor(charmander);
        timePerceptionManager.append(charmander );

        world.run();

    }
}
