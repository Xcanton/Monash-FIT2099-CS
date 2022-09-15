package game.time;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * A global Singleton manager that gives time perception  on the affected instances.
 * TODO: you may modify (add or remove) methods in this class if you think they are not necessary.
 * HINT: refer to Bootcamp Week 5 about static factory method.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class TimePerceptionManager {
    /**
     * A list of polymorph instances (any classes that implements TimePerception,
     * such as, a Charmander implements TimePerception, it will be stored in here)
     */
    private final List<TimePerception> timePerceptionList;

    private int turn=0;

    private TimePeriod shift=TimePeriod.DAY; // DAY or NIGHT

    /**
     * A singleton instance
     */
    private static TimePerceptionManager instance= null;

    /**
     * Get the singleton instance of time perception manager
     *
     * @return TimePerceptionManager singleton instance
     *
     */
    public static TimePerceptionManager getInstance() {
        if (instance == null) {
            instance = new TimePerceptionManager();
        }
        return instance;
    }

    /**
     * Private constructor
     */
    private TimePerceptionManager() {
        timePerceptionList = new ArrayList<>();
        turn = 0;
    }

    /**
     * Traversing through all instances in the list and execute them
     * By doing this way, it will avoid using `instanceof` all over the place.
     *
     * FIXME: write a relevant logic (i.e., increment turns choose day or night) and call this method once at every turn.
     */
    public void run() {
        switch(shift){
            case DAY:
                for (TimePerception t: timePerceptionList)
                    t.dayEffect();
                System.out.format("It is Day-time (Turn %d)%n",turn);
                if (turn%4==0 & turn!=0) {
                    {shift=TimePeriod.NIGHT;}
                    break;
                }
                break;
            case NIGHT:
                for (TimePerception t: timePerceptionList)
                    t.nightEffect();
                System.out.format("It is Night-time (Turn %d)%n",turn);
                if (turn%4==0& turn!=0)
                    {shift=TimePeriod.DAY;}
                    break;

        }
        turn+=1;
    }


    /**
     * Add the TimePerception instance to the list
     * @param objInstance any instance that implements TimePerception
     */
    public void append(TimePerception objInstance) {
    timePerceptionList.add(objInstance);
    }


    /**
     * Remove a TimePerception instance from the list
     *
     * FIXME: [OPTIONAL] run cleanUp once every turn if you don't want to
     *        have too many instances in the list (e.g., memory leak)
     * @param objInstance object instance
     */
    public void cleanUp(TimePerception objInstance) {
    }

}
