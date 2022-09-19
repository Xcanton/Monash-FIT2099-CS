package game;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.*;

public class Tools {
    static GameMap gameMap;
    public Tools(GameMap gameMap) {
        this.gameMap=gameMap;
    }
    public static boolean chanceSimulation(int chance){
        Random rand = new Random();
        return rand.nextInt(100) <= chance;

    }
    public static boolean checkGroundSurroundings(Element element, Location location){
        switch(element){
            case WATER :
                if (checkGroundSurroundingsHelper(element,location)==2){
                    return true;
            }
            case GRASS:
                if (checkGroundSurroundingsHelper(element,location)==1){
                    return true;
                }
            case FIRE:
                return true;
        }
        return false;
    }
    public static Actor checkActorSurroundings(Actor actor,Location location){
        return checkActorSurroundingsHelper(actor, location);
    }

    public static int checkGroundSurroundingsHelper(Element element,Location location){
        int surroundings = 0;
        Ground ground;
        List <Element> elementCompare = new ArrayList<>();
        elementCompare.add(element);
        ground=gameMap.at(location.x()+1, location.y()).getGround(); //Check east
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x()+1, location.y()+1).getGround(); // check north east
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x(), location.y()+1).getGround();// check north
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x()-1, location.y()+1).getGround();// check north west
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x()-1, location.y()).getGround();// check west
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x()-1, location.y()-1).getGround();// check south west
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x(), location.y()-1).getGround();// check south
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }

        ground=gameMap.at(location.x()+1, location.y()-1).getGround();// check south east
        ElementsHelper.hasAnySimilarElements(ground,elementCompare);
        if (ElementsHelper.hasAnySimilarElements(ground,elementCompare))
        {
            surroundings++;
        }
        return surroundings;
    }
    public static Actor checkActorSurroundingsHelper(Actor actor, Location location){
        Actor otherActor;
        // list of the actor's element
        List <Element> actorElement= new ArrayList<>();
        actorElement.add(actor.findCapabilitiesByType(Element.class).get(0));
        otherActor=gameMap.at(location.x()+1, location.y()).getActor(); // check east
        try {
            if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)) {
                return otherActor;
            }
        }catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x()+1, location.y()+1).getActor(); // check north east
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x(), location.y()+1).getActor();// check north
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x()-1, location.y()+1).getActor();// check north west
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x()-1, location.y()).getActor();// check west
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x()-1, location.y()-1).getActor();// check south west
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x(), location.y()-1).getActor();// check south
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        try{
        otherActor=gameMap.at(location.x()+1, location.y()-1).getActor();// check south east
        if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)&& otherActor!=null) {
            return otherActor;
        }}catch (NullPointerException e){}
        return null;
    }
}
