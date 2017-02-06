package sauvegarde;

import diceGame.Randomizer;

/**
 * Created by Nicochu on 06/02/2017.
 */
public class SauvegardeFactory {

    private static SauvegardeFactory INSTANCE = null;

    public static synchronized SauvegardeFactory getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new SauvegardeFactory();
        }
        return INSTANCE;
    }

    public Sauvegarde creerSauvegarde(int typeSauvegarde) {
        Sauvegarde sauvegarde = null;
        switch (typeSauvegarde) {
            case 1:
                sauvegarde = new SauvegardeMariaDB();
                break;
            case 2:
                sauvegarde = new SauvegardeXML();
                break;
            case 3:
                sauvegarde = new SauvegardeMongoDB();
                break;
        }
        return sauvegarde;
    }
}
