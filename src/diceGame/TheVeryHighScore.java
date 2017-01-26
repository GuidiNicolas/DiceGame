package diceGame;

/**
 * Created by Nicochu on 26/01/2017.
 */
public class TheVeryHighScore {
    int highScore;

    public TheVeryHighScore() {
        int choixPersistance = Randomizer.randomize(1,3);

        switch (choixPersistance) {
            case 1 :
        }
    }

    public void majScore(int score) {
        highScore += score;
    }
}
