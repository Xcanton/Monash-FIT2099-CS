package game;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Tools {
    static GameMap gameMap;
    public Tools(GameMap gameMap) {
        this.gameMap=gameMap;
    }
    public static boolean chanceSimulation(int chance){
        Random rand = new Random();
        return rand.nextInt(100) <= chance;

    }
    public static boolean checkGrassSurrounding(Location location){
        int check_x, check_y;
        // check right of ground
        check_x=location.x()+1;
        check_y= location.y();
        ElementsHelper.hasAnySimilarElements(location.getGround(), Collections.singletonList(Element.GRASS));
        return true;
    }
    public static boolean checkElementSurroundings(Element element, Location location){
        switch(element){
            case WATER :
                if (checkSurroundings(element,location)==2){
                    return true;
            }
            case GRASS:
                if (checkSurroundings(element,location)==1){
                    return true;
                }
            case FIRE:
                return true;
        }
        return false;
    }

    public static int checkSurroundings(Element element,Location location){
        int surroundings = 0;
        Ground ground;
        List elementCompare;
        elementCompare=Collections.singletonList(element);
        ground=gameMap.at(location.x()+1, location.y()).getGround(); //Check east
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x()+1, location.y()+1).getGround(); // check north east
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x(), location.y()+1).getGround();// check north
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x()-1, location.y()+1).getGround();// check north west
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x()-1, location.y()).getGround();// check west
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x()-1, location.y()-1).getGround();// check south west
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x(), location.y()-1).getGround();// check south
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        gameMap.at(location.x()+1, location.y()-1).getGround();// check south east
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }
        return surroundings;
    }
}
