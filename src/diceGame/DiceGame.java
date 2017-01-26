package diceGame;

import javafx.fxml.FXML;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class DiceGame {

    private Player p1;
    private Dice d1;
    private Dice d2;

    private static DiceGame INSTANCE = null;

    @FXML
    public static synchronized DiceGame getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new DiceGame();
        }
        return INSTANCE;
    }

    @FXML
    public void start()
    {
        d1.roll();
        d2.roll();
        if(d1.getfaceValue()+d2.getfaceValue()==11)
        {
            p1.incrScore();
        }
    }
}
