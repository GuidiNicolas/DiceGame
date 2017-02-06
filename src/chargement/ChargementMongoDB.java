package chargement;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import diceGame.Player;
import javafx.scene.control.TextArea;
import org.bson.Document;

/**
 * Created by Nicochu on 06/02/2017.
 */
public class ChargementMongoDB extends Chargement {

    static MongoClient mc ;
    static MongoDatabase mdb ;
    static MongoCollection collection;

    public void chargerScores(TextArea scores) {
        System.out.println("Chargement par MongoDB");

        mc = new MongoClient("localhost",27017);
        mdb = mc.getDatabase("dicegame");
        collection = mdb.getCollection("scores");

        FindIterable<Document> res = collection.find();
        for(Document d : res) {
            Player p = new Player();
            p.setNom(d.get("nom").toString());
            p.setScore(Integer.parseInt(d.get("score").toString()));

            players.add(p);
        }

        afficherScores(scores);
    }


}
