package diceGame;

import javafx.fxml.FXML;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class DiceGame {

    private static DiceGame INSTANCE = null;

    Die d1;
    Die d2;
    int resultat;
    int score;

    public Die getD1() {
        return d1;
    }

    public Die getD2() {
        return d2;
    }

    public int getScore() {
        return score;
    }

    public int getResultat() {
        return resultat;
    }

    public DiceGame() {
        d1 = new Die();
        d2 = new Die();
        resultat = 0;
        score = 0;
    }

    public static synchronized DiceGame getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new DiceGame();
        }
        return INSTANCE;
    }

    @FXML
    public void play()
    {
        d1.roll();
        d2.roll();

        resultat = d1.getFaceValue() + d2.getFaceValue();

        if (resultat == 7) {
            score++;
        }

    }
}
