package controlleurs;

import diceGame.DiceGame;
import diceGame.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ControllerDiceGame implements Initializable, Observer {

    int nbTour = 1;
    int nbDie = 1;

    @FXML
    public Button boutonJouer, boutonFermer;

    @FXML
    public Label score, score1, score2, resultat, lancersRestants;

    @FXML
    public ImageView déDroit, déGauche;

    public void play() {
        DiceGame.getInstance().play();

        score.setText(Integer.toString(DiceGame.getInstance().getScore()));
        resultat.setText(Integer.toString(DiceGame.getInstance().getResultat()));

        nbTour++;

        if (nbTour > 10) {
            boutonJouer.setDisable(true);
            boutonFermer.setDisable(false);

            System.out.println(Player.getInstance().getScore());

        }

        lancersRestants.setText(Integer.toString(11-nbTour));
    }

    public void update(Observable o, Object arg) {

        Integer nb = (Integer)arg;
        Image die = new Image("images/"+nb+".JPG");

        if (nbDie == 1) {
            déDroit.setImage(die);
            nbDie = 2;
        }
        else {
            déGauche.setImage(die);
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
        boutonFermer.setDisable(true);
        lancersRestants.setText(Integer.toString(11-nbTour));
        DiceGame.getInstance().getD1().addObserver(this);
        DiceGame.getInstance().getD2().addObserver(this);
    }
}
