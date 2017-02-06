package controlleurs;

import chargement.Chargement;
import chargement.ChargementFactory;
import diceGame.Player;
import diceGame.Randomizer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.Main;
import persistance.GestionPersistance;
import sauvegarde.Sauvegarde;
import sauvegarde.SauvegardeFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Nicochu on 03/02/2017.
 */
public class ControllerHighScores implements Initializable {

    @FXML
    public TextArea scores;

    public void initialize(URL location, ResourceBundle resources) {
        scores.setText("");
        chargerDonnees();
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
