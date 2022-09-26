package game.time;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public interface TimePerception {
    /**
     * Night effect which is run every night turn
     */
    void dayEffect();

    /**
     * Day effect that is ran every day turn
     */
    void nightEffect();

    /**
     * a default interface method that register current instance to the Singleton manager.
     * It allows corresponding class uses to be affected by global reset
     */
    default void registerInstance(){
        TimePerceptionManager.getInstance().append(this);
    }
}
