package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.environment.*;

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
        Tools tools= new Tools(gameMap);
        world.addGameMap(gameMap);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1,gameMap);
        world.addPlayer(ash, gameMap.at(32, 10));
        //Add first pokemon - Charmander
        world.run();

    }
}
