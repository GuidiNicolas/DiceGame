package diceGame;

import java.util.Random;

/**
 * Created by Nicochu on 26/01/2017.
 */
public class Randomizer{

    private static Randomizer INSTANCE = null;

    public static synchronized Randomizer getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Randomizer();
        }
        return INSTANCE;
    }

    public int randomize(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max) + min);
    }
}
