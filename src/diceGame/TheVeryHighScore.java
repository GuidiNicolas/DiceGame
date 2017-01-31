package diceGame;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicochu on 26/01/2017.
 */
public class TheVeryHighScore {
    int highScore;
    int choix;

    public void TheVeryHighScore() {

    }

    public void choisirPersistance() {
        Randomizer rand = Randomizer.getInstance();
        choix = rand.randomize(1,3);
    }
    public void majScore(int score) {
        highScore += score;
    }
}
