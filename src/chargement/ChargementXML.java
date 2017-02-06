package chargement;

import diceGame.Player;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Nicochu on 06/02/2017.
 */
public class ChargementXML extends Chargement {

    public void chargerScores(TextArea scores) {
        System.out.println("Chargement par XML");

        StringWriter out = new StringWriter();
        String fichierXML = "";
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("scores.XML")));
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
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File("scores.XML")));
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
            p.setNom(resultat.substring(resultat.indexOf("<nom>")+9,resultat.indexOf("</nom>")-3).trim());
            p.setScore(Integer.parseInt(resultat.substring(resultat.indexOf("<score>")+11,resultat.indexOf("</score>")-3).trim()));
            players.add(p);

            fichierXML = fichierXML.substring(0,deb) + fichierXML.substring(fin+11,fichierXML.length());
        }

        setPlayers(players);

        afficherScores(scores);
    }
}
