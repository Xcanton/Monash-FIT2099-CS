package game.utils;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.environment.*;
import game.items.Pokefruit;
import game.pokemons.Bulbasaur;
import game.pokemons.Charizard;
import game.pokemons.Charmander;
import game.pokemons.Squirtle;

/**
 * The main class to start the game.
 * Created by: Chongjie Chen
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
                "...........,,,................................,.,..^^^^O^^^",
                ".....................................................^^^^^^",
                "........................................................^^^",
                "..........................#######...........,,...........^^",
                "..........................#_____#...........,.............^",
                "..,,,...............,.....#_____#..........................",
                "..,.,......~..............###_###..........................",
                "...~~~~~~~~................................................",
                "....~~~~~..................................................",
                "~~W~~~~.,.....................O....T.,,,...................",
                "~~~~~~.,,,...........................,.,...................",
                "~~~~~~~~~............................,.....................");
        GameMap gameMap = new GameMap(groundFactory, map);
        Tools tools= new Tools(gameMap);

        //Add player - Ash
        Player ash = new Player("Ash", '@', 1,gameMap);
        world.addGameMap(gameMap);
        world.addPlayer(ash, gameMap.at(32, 10));
        ash.setLocation(32,10);
        //Add first pokemon - Charmander
        Charmander charmander= new Charmander();
        gameMap.at(31,10).addActor(charmander);

        Squirtle squirtle= new Squirtle();
        gameMap.at(30,10).addActor(squirtle);

        Bulbasaur bulbasaur= new Bulbasaur();
        gameMap.at(30,11).addActor(bulbasaur);

        world.run();



    }
}
