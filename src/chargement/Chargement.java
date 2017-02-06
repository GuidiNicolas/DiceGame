package chargement;

import diceGame.Player;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

/**
 * Created by Nicochu on 06/02/2017.
 */
public abstract class Chargement {

    ArrayList<Player> players = new ArrayList<Player>();

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public abstract void chargerScores(TextArea scores);

    public void afficherScores(TextArea scores) {
        for (Player p : players) {
            scores.setText(scores.getText() + p.getNom() + " : " + p.getScore() + "\n");
        }
    }
}
