package game.utils;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.*;

/**
 * Tools class is a class used to check condtions
 */
public class Tools {
    static GameMap gameMap;
    public Tools(GameMap gameMap) {
        this.gameMap=gameMap;
    }

    /**
     * Simulate probability
     * @param chance the chance it will succeed
     * @return returns true or false
     */
    public static boolean chanceSimulation(int chance){
        Random rand = new Random();
        return rand.nextInt(100) <= chance;

    }
    public static boolean isActorAt(Location location){
        return (gameMap.isAnActorAt(location));
    }
    public static boolean checkGroundSurroundings(Element element, Location location, int requirement){
        if (checkGroundSurroundingsHelper(element,location)>requirement){
        return true;
        }
        return false;
    }
    public static Actor checkActorSurroundings(Actor actor,Location location){
        return checkActorSurroundingsHelper(actor, location);
    }

    /**
     * Check the surrounding of a ground
     * @param element the element being checked againist
     * @param location the location of the ground
     * @return returns the amount of similar elements in the surrounding
     */
    public static int checkGroundSurroundingsHelper(Element element,Location location){
        int surroundings = 0;
        Ground ground;
        List <Element> elementCompare = new ArrayList<>();
        elementCompare.add(element);
        try {
            ground = gameMap.at(location.x() + 1, location.y()).getGround(); //Check east
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x() + 1, location.y() + 1).getGround(); // check north east
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x(), location.y() + 1).getGround();// check north
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x() - 1, location.y() + 1).getGround();// check north west
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x() - 1, location.y()).getGround();// check west
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x() - 1, location.y() - 1).getGround();// check south west
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x(), location.y() - 1).getGround();// check south
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }

            ground = gameMap.at(location.x() + 1, location.y() - 1).getGround();// check south east
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                surroundings++;
            }
        }catch (ArrayIndexOutOfBoundsException e){

        }
        return surroundings;
    }

    /**
     * Checks the actor's surroundings
     * @param actor the actor that is being checked against
     * @param location the location of the actor
     * @return returns adjacent actors if there is any
     */
    public static Actor checkActorSurroundingsHelper(Actor actor, Location location){
        Actor otherActor;
        // list of the actor's element
        List <Element> actorElement= new ArrayList<>();
        actorElement.add(actor.findCapabilitiesByType(Element.class).get(0));
        try {
            try {
                otherActor = gameMap.at(location.x() + 1, location.y()).getActor(); // check east
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement)) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x() + 1, location.y() + 1).getActor(); // check north east
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x(), location.y() + 1).getActor();// check north
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x() - 1, location.y() + 1).getActor();// check north west
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x() - 1, location.y()).getActor();// check west
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x() - 1, location.y() - 1).getActor();// check south west
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x(), location.y() - 1).getActor();// check south
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
            try {
                otherActor = gameMap.at(location.x() + 1, location.y() - 1).getActor();// check south east
                if (!ElementsHelper.hasAnySimilarElements(otherActor, actorElement) && otherActor != null) {
                    return otherActor;
                }
            } catch (NullPointerException e) {
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        return null;
    }

    /**
     * Check the ground
     * @param actor the actor that is checking the condition
     * @param location the location of the actor
     * @return returns true if elements are the same, false otherwise
     */
    public static boolean checkGround(Actor actor, Location location){
        try {
            return actor.findCapabilitiesByType(Element.class).get(0)==location.getGround().findCapabilitiesByType(Element.class).get(0);
        }catch (IndexOutOfBoundsException e){

        }
        return false;
    }

    /**
     * Expand method to expand grounds
     * @param location location of the ground
     * @param self the ground that is being expanded
     */
    public static void expand(Location location,Ground self) {
        try {
            Element element = self.findCapabilitiesByType(Element.class).get(0);
            Ground ground;
            List<Element> elementCompare = new ArrayList<>();
            elementCompare.add(element);
            List <Location> locations= new ArrayList<>();

            int new_x,new_y;
            new_x= location.x()+1;
            new_y= location.y();
            ground = gameMap.at(new_x, new_y).getGround(); //Check east
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x()+1;
            new_y= location.y()+1;
            ground = gameMap.at(new_x,new_y).getGround(); // check north east
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x();
            new_y= location.y()+1;
            ground = gameMap.at(new_x,new_y).getGround();// check north
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x()-1;
            new_y= location.y()+1;
            ground = gameMap.at(new_x,new_y).getGround();// check north west
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x()-1;
            new_y= location.y();
            ground = gameMap.at(new_x,new_y).getGround();// check west
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x()-1;
            new_y= location.y()-1;
            ground = gameMap.at(new_x,new_y).getGround();;// check south west
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x();
            new_y= location.y()-1;
            ground = gameMap.at(new_x,new_y).getGround();// check south
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }

            new_x= location.x()+1;
            new_y= location.y()-1;
            ground = gameMap.at(new_x,new_y).getGround();// check south east
            ElementsHelper.hasAnySimilarElements(ground, elementCompare);
            if (!ElementsHelper.hasAnySimilarElements(ground, elementCompare)) {
                gameMap.at(new_x, new_y).setGround(self);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

}
