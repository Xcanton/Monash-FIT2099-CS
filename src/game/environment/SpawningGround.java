package game.environment;

import edu.monash.fit2099.engine.positions.Ground;

public abstract class SpawningGround extends Ground {
    private final int spawnChance;
    private final int dropChance;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param spawnChance 
     * @param dropChance
     */
    public SpawningGround(char displayChar, int spawnChance, int dropChance) {
        super(displayChar);
        this.spawnChance = spawnChance;
        this.dropChance = dropChance;
    }
}
