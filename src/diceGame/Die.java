package diceGame;

import java.util.Observable;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class Die extends Observable {

    private Integer faceValue;

    public Integer getFaceValue() {
        return faceValue;
    }

    public void roll()
    {
        faceValue = Randomizer.getInstance().randomize(1,6);

        setChanged();
        notifyObservers(this.faceValue);
    }

    public Die()
    {
        faceValue = -1;
    }
}