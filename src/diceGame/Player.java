package diceGame;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class Player implements Observer {

    private static Player INSTANCE = null;

    private String name;

    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player()
    {
        DiceGame.getInstance().addObserver(this);
        score = 0;
        name = "nom inconnu";
    }

    public int getScore() {
        return score;
    }

    public static synchronized Player getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Player();
        }
        return INSTANCE;
    }

    public void sauvegarderScore() {
        int choix = Randomizer.getInstance().randomize(1,3);

    }

    public void update(Observable o, Object arg) {
        score = (Integer)arg;
    }
}
