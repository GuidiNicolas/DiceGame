package sauvegarde;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Nicochu on 05/02/2017.
 */
public class SauvegardeMongoDB extends Sauvegarde {

    static MongoClient mc ;
    static MongoDatabase mdb ;
    static MongoCollection collection;

    public void sauvegarder() {
        System.out.println("Sauvegarde par MongoDB");

        Document document = toDocument();

        mc = new MongoClient("localhost",27017);
        mdb = mc.getDatabase("dicegame");
        collection = mdb.getCollection("scores");

        collection.insertOne(document);
    }

    public Document toDocument() {
        Document db = new Document();
        db.put("nom", getPlayer().getNom());
        db.put("score", getPlayer().getScore());
        return db;
    }

}
