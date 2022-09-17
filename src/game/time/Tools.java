package game.time;
import java.util.Random;
public class Tools {
    public Tools() {
    }
    public static boolean chanceSimulation(int chance){
        Random rand = new Random();
        return rand.nextInt(100) <= chance;

    }
}
