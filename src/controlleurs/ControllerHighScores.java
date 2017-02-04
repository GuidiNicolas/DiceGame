package controlleurs;

import diceGame.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import main.Main;
import persistance.GestionPersistance;

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
        int choix = 1; //Randomizer.getInstance().randomize(1,3);

        switch (choix) {
            case 1 : chargerXML();
                break;
            case 2 : chargerMariaDB();
        }
    }

    public void chargerXML() {

        StringWriter out = new StringWriter();
        String fichierXML = "";
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("src/sauvegarde/scores.XML")));
            int b;
            while ((b=in.read()) != -1)
                out.write(b);
            out.flush();
            out.close();
            in.close();

            fichierXML = out.toString();
        }
        catch (IOException ie)
        {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/sauvegarde/scores.XML")));
                // normalement si le fichier n'existe pas, il est crée à la racine du projet
                writer.write("");

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        ArrayList<Player> players = new ArrayList<Player>();

        while (fichierXML.contains("<resultat>") && fichierXML.contains("</resultat>")) {
            int deb = fichierXML.indexOf("<resultat>");
            int fin = fichierXML.indexOf("</resultat>");
            String resultat = fichierXML.substring(deb,fin+11);

            Player p = new Player();
            p.setNom(resultat.substring(resultat.indexOf("<nom>")+9,resultat.indexOf("</nom>")-3));
            p.setScore(Integer.parseInt(resultat.substring(resultat.indexOf("<score>")+11,resultat.indexOf("</score>")-3)));
            players.add(p);

            fichierXML = fichierXML.substring(0,deb) + fichierXML.substring(fin+11,fichierXML.length());
        }

        afficherScores(players);
    }

    public void chargerMariaDB() {
        ArrayList<Player> players =  (ArrayList)GestionPersistance.listePlayers();
        GestionPersistance.clear();
        afficherScores(players);
    }

    public void afficherScores(ArrayList<Player> players) {
        for (Player p : players) {
            scores.setText(scores.getText() + p.getNom() + " : " + p.getScore() + "\n");
        }
    }
}
