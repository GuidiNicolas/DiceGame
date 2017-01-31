package controlleurs;

import diceGame.DiceGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ControllerDiceGame implements Initializable, Observer {

    DiceGame dg;
    int nbTour = 1;
    int nbDie = 1;

    @FXML
    public Button boutonJouer;

    @FXML
    public Label score, score1, score2, resultat, lancersRestants;

    public void play() {
        dg.play();

        score.setText(Integer.toString(dg.getScore()));
        resultat.setText(Integer.toString(dg.getResultat()));

        nbTour++;

        if (nbTour > 10) {
            boutonJouer.setDisable(true);
        }

        lancersRestants.setText(Integer.toString(11-nbTour));
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

    public void afficherRegles() {
        Main.regles.showAndWait();
    }

    public void fermer() {
        System.exit(0);
    }

    public void initialize(URL location, ResourceBundle resources) {
        dg = DiceGame.getInstance();
        lancersRestants.setText(Integer.toString(11-nbTour));
        dg.getD1().addObserver(this);
        dg.getD2().addObserver(this);
    }
}
