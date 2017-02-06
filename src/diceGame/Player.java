package diceGame;

import javax.persistence.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicochu on 24/01/2017.
 */

@Entity
@Table(name="scores")
public class Player implements Observer {

    private static Player INSTANCE = null;

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nom;
    private int score;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Player()
    {
        DiceGame.getInstance().addObserver(this);
        score = 0;
        nom = "nom inconnu";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static synchronized Player getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Player();
        }
        return INSTANCE;
    }

    public void update(Observable o, Object arg) {
        score = (Integer)arg;
    }
}
