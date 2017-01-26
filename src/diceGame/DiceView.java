package diceGame;

import javafx.fxml.FXML;

import java.util.Observable;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class DiceView {

    @FXML
    private String affichage;

    DiceView(String affichage)
    {
        this.affichage=affichage;
    }

    @FXML
    public void update(Observable observable, Object o) {
        affichage = ""+(Integer) o;
    }
}
