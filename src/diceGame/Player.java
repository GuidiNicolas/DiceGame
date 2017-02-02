package diceGame;

import persistance.GestionPersistance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicochu on 24/01/2017.
 */

@Entity
@Table(name="scores")
public class Player implements Observer {

    private static Player INSTANCE = null;

    @Id
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

    public static synchronized Player getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Player();
        }
        return INSTANCE;
    }

    public void sauvegarderScore() {
        int choix = 2; //Randomizer.getInstance().randomize(1,3);

        switch (choix) {
            case 1 : sauvegarderXML();
                break;
            case 2 : sauvegarderMariaDB();
        }

    }

    public void sauvegarderXML() {

        StringWriter out = new StringWriter();
        String fichierXML = "";
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("src/sauvegarde.scoresXML/scores.XML")));
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
            ie.printStackTrace();
        }

        if ( !(fichierXML.startsWith("<resultats>")&&(fichierXML.endsWith("</resultats>"))) ) {
            fichierXML = "<resultats>\n</resultats>";
        }

        String sauvegarde = "\t<resultat>\n\t\t<nom>\n\t\t\t"+ getNom()+"\n\t\t</nom>\n\t\t<score>\n\t\t\t"+getScore()+"\n\t\t</score>\n\t</resultat>\n";

         fichierXML = fichierXML.substring(0,fichierXML.length()-12) + sauvegarde + "</resultats>";

        try {
            FileWriter MyFile= new FileWriter("src/sauvegarde.scoresXML/scores.XML",false);
            MyFile.write(fichierXML);
            MyFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sauvegarderMariaDB() {
        GestionPersistance.sauvegarder(this);
    }

    public void update(Observable o, Object arg) {
        score = (Integer)arg;
    }
}
