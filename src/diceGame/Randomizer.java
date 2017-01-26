package diceGame;

import java.util.Random;

/**
 * Created by Nicochu on 26/01/2017.
 */
public class Randomizer {

    public static int randomize(int min, int max) {
        Random rand = new Random();
        return  rand.nextInt(max) + min;
    }
}
