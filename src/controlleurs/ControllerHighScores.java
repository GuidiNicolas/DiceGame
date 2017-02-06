package controlleurs;

import chargement.Chargement;
import chargement.ChargementFactory;
import diceGame.Randomizer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Nicochu on 03/02/2017.
 */
public class ControllerHighScores implements Initializable {

    @FXML
    public TextArea scores;

    public void initialize(URL location, ResourceBundle resources) {
        scores.setText("");
        try {
            chargerDonnees();
        }
        catch (Exception e) {
            System.err.println("Erreur lors du chargement des données, fermeture de l'application");
            System.exit(0);
        }
    }

    public void fermer() {
        Main.highScores.close();
        Main.diceGame.show();
    }

    public void chargerDonnees() {
        Chargement chargement = ChargementFactory.getInstance().creerChargement(Randomizer.getInstance().randomize(1,3));
        chargement.chargerScores(scores);
    }
}
