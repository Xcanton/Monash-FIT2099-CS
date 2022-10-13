package game.Center;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;

import java.util.Arrays;
import java.util.List;

public class PokemonCenter {
    public List<String> map = Arrays.asList(
            "#################",
            "#_______________#",
            "#_____....._____#",
            "#_______________#",
            "#_______________#",
            "#######_._#######");
    private GameMap globalMap;
    private Location formerLocation;
    private Door privateDoor;
    private FancyGroundFactory globalGroundFactory;
    private World globalWorld;

    public PokemonCenter(World world, GameMap gameMap, Location loca, String outerMapName, FancyGroundFactory groundFactory) {
        this.globalMap = gameMap;
        this.formerLocation = loca;
        this.globalGroundFactory = groundFactory;
        this.globalWorld = world;

        GameMap currentMap = new GameMap(groundFactory, map);
        this.globalWorld.addGameMap(currentMap);
        privateDoor = new Door(outerMapName, this.formerLocation);
        currentMap.at(8,5).addItem(this.privateDoor);
        this.formerLocation.addItem(new Door("Pokemon Center", currentMap.at(8,5)));
    }
}
