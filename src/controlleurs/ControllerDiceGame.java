package controlleurs;

import diceGame.DiceGame;
import diceGame.Player;
import diceGame.Randomizer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import main.Main;
import sauvegarde.Sauvegarde;
import sauvegarde.SauvegardeFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ControllerDiceGame implements Initializable, Observer {

    int nbTour = 1;
    final int nbTourFinal = 10;
    int nbDie = 1;
    int timer = 1;

    public Image[] images = new Image[6];

    @FXML
    public Button boutonJouer, boutonFermer, boutonRejouer;

    @FXML
    public Label score, resultat, lancersRestants;

    @FXML
    public ImageView déDroit, déGauche;

    public void play() {

        boutonJouer.setDisable(true);

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (timer == 15) {
                    DiceGame.getInstance().play();

                    score.setText(Integer.toString(DiceGame.getInstance().getScore()));
                    resultat.setText(Integer.toString(DiceGame.getInstance().getResultat()));

                    nbTour++;
                    lancersRestants.setText(Integer.toString(nbTourFinal+1-nbTour));

                    boutonJouer.setDisable(false);

                    if (nbTour > nbTourFinal) {
                        boutonJouer.setDisable(true);
                        boutonFermer.setDisable(false);
                        boutonRejouer.setDisable(false);

                        Sauvegarde sauvegarde = SauvegardeFactory.getInstance().creerSauvegarde(Randomizer.getInstance().randomize(1,3));
                        sauvegarde.sauvegarder();

                        try {
                            Main.highScores.setScene(new Scene((Parent)FXMLLoader.load(getClass().getResource("../vues/highScores.fxml")),600, 450));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    timer = 0;
                }
                else {
                    DiceGame.getInstance().playGraphique();
                }
                timer++;
            }
        }));
        fiveSecondsWonder.setCycleCount(15);
        fiveSecondsWonder.play();
    }

    public void rejouer() {
        DiceGame.getInstance().reset();

        nbTour = 1;
        nbDie = 1;
        timer = 1;

        score.setText(Integer.toString(DiceGame.getInstance().getScore()));
        resultat.setText(Integer.toString(DiceGame.getInstance().getResultat()));
        lancersRestants.setText("10");
        resultat.setText("");

        boutonJouer.setDisable(false);
        boutonFermer.setDisable(true);
        boutonRejouer.setDisable(true);

        déGauche.setImage(null);
        déDroit.setImage(null);

    }

    public void update(Observable o, Object arg) {
        Integer nb = (Integer)arg;

        if (nbDie == 1) {
            déGauche.setImage(images[nb-1]);
            nbDie = 2;
        }
        else {
            déDroit.setImage(images[nb-1]);
            nbDie = 1;
        }
    }

    public void chargerImages() {
        for (int i=0 ; i<6 ; i++) {
            images[i] = new Image("images/"+(i+1)+".JPG");
        }
    }

    public void afficherRegles() {
        Main.diceGame.close();
        Main.regles.showAndWait();
    }

    public void afficherScores() {
        Main.diceGame.close();
        Main.highScores.showAndWait();
    }

    public void fermer() {
        System.exit(0);
    }

    public void initialize(URL location, ResourceBundle resources) {
        boutonFermer.setDisable(true);
        boutonRejouer.setDisable(true);
        boutonJouer.setDefaultButton(true);
        lancersRestants.setText(Integer.toString(nbTourFinal+1-nbTour));
        chargerImages();
        DiceGame.getInstance().getD1().addObserver(this);
        DiceGame.getInstance().getD2().addObserver(this);
    }
}
