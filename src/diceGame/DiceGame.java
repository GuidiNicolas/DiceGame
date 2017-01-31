package diceGame;

import javafx.fxml.FXML;

import java.util.ArrayList;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class DiceGame {

    private static DiceGame INSTANCE = null;

    Die d1;
    Die d2;

    public static synchronized DiceGame getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new DiceGame();
        }
        return INSTANCE;
    }

    @FXML
    public ArrayList<Die> play()
    {
        ArrayList<Die> dice = new ArrayList<Die>();

        d1.roll();
        d2.roll();

        dice.add(d1);
        dice.add(d2);

        return dice;
    }
}
