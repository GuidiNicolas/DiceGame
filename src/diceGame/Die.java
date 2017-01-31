package diceGame;

import javafx.fxml.FXML;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class Die implements Observer {

    @FXML
    private Integer faceValue;

    @FXML
    public void roll()
    {
        Randomizer rand = Randomizer.getInstance();
        rand.randomize(1,6);
    }

    public Die()
    {
        faceValue=1;
    }

    public void update(Observable o, Object arg) {
        faceValue = (Integer)arg;
    }
}