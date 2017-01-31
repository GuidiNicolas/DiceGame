package diceGame;

import java.util.Observable;
import java.util.Random;

/**
 * Created by Nicochu on 26/01/2017.
 */
public class Randomizer extends Observable {

    private static Randomizer INSTANCE = null;
    int randomVal;

    public static synchronized Randomizer getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Randomizer();
        }
        return INSTANCE;
    }

    public void randomize(int min, int max) {
        Random rand = new Random();
        randomVal = rand.nextInt(max) + min;

        setChanged();
        notifyObservers(this.randomVal);
    }
}
