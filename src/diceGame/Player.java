package diceGame;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Nicochu on 24/01/2017.
 */
public class Player implements Observer {

    private static Player INSTANCE = null;

    private String name;

    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player()
    {
        DiceGame.getInstance().addObserver(this);
        score = 0;
        name = "nom inconnu";
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
        int choix = 1; //Randomizer.getInstance().randomize(1,3);

        switch (choix) {
            case 1 : sauvegarderJson();
        }

    }

    public void sauvegarderJson() {

        JsonFactory jsonF = new JsonFactory();

        JsonGenerator jg = null;
        try {
            jg = jsonF.createJsonGenerator(new FileOutputStream("src/ScoresJSON/"+getName()+".json"), JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jg.useDefaultPrettyPrinter(); // enable indentation just to make debug/testing easier
        try {
            jg.writeStartObject();
            jg.writeStringField("nomJoueur", getName());
            jg.writeNumberField("score", getScore());
            jg.writeEndObject();
            jg.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Observable o, Object arg) {
        score = (Integer)arg;
    }
}
