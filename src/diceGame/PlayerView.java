package diceGame;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class PlayerView implements Observer {
    private String joueur;
    private String score;
    private String resultat;

    public PlayerView(String joueur, String score, String resultat)
    {
        this.joueur=joueur;
        this.score=score;
        this.resultat=resultat;
    }


    public void update(Observable observable, Object o) {
        joueur = (observable.toString());
        score = (""+((Integer) o));
        resultat = ("victoire");
    }
}