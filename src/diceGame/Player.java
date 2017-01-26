package diceGame;

import javafx.fxml.FXML;

import java.util.Observable;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class Player extends Observable {

    @FXML
    private String name;

    @FXML
    private int score;

    public Player(String nom)
    {
        score = 0;
        name = nom;
    }

    @FXML
    public void incrScore() {
        score += 10;
        setChanged();
        notifyObservers(this.score);
    }

    public String getName() {
        return name;
    }
}
