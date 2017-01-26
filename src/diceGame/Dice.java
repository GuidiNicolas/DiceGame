package diceGame;

import javafx.fxml.FXML;

import java.util.Observable;
import java.util.Random;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class Dice extends Observable {

    @FXML
    private Integer faceValue;

    @FXML
    public void roll()
    {
        Random rand = new Random();
        faceValue = rand.nextInt(6) + 1;
        setChanged();
        notifyObservers(this.faceValue);
    }

    public Dice()
    {
        faceValue=1;
    }

    public int getfaceValue()
    {
        return faceValue;
    }
}