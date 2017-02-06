package chargement;

import javafx.scene.control.TextArea;
import persistance.GestionPersistance;

import java.util.ArrayList;

/**
 * Created by Nicochu on 06/02/2017.
 */
public class ChargementMariaDB extends Chargement {

    public void chargerScores(TextArea scores) {
        System.out.println("Chargement par MariaDB");

        setPlayers((ArrayList) GestionPersistance.listePlayers());
        GestionPersistance.clear();

        afficherScores(scores);
    }
}
