package controlleurs;

import diceGame.DiceGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ControllerDiceGame implements Initializable, Observer {

    DiceGame dg;
    int nbTour = 1;
    int nbDie = 1;

    @FXML
    public static Button boutonJouer;

    @FXML
    public Label score1;

    @FXML
    public Label score2;

    @FXML
    public Label score;

    @FXML
    public Label resultat;

    public void play() {
        dg.play();

        score.setText(Integer.toString(dg.getScore()));
        resultat.setText(Integer.toString(dg.getResultat()));

        nbTour++;

        if (nbTour == 10) {
            boutonJouer.setDisable(true);
        }
    }

    public void update(Observable o, Object arg) {
        if (nbDie == 1) {
            score1.setText(Integer.toString((Integer)arg));
            nbDie = 2;
        }
        else {
            score2.setText(Integer.toString((Integer)arg));
            nbDie = 1;
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        dg = new DiceGame();
        dg.getD1().addObserver(this);
        dg.getD2().addObserver(this);
    }
}
