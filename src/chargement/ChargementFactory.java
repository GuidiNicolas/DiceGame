package chargement;

/**
 * Created by Nicochu on 06/02/2017.
 */
public class ChargementFactory {

    private static ChargementFactory INSTANCE = null;

    public static synchronized ChargementFactory getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new ChargementFactory();
        }
        return INSTANCE;
    }

    public Chargement creerChargement(int typeSauvegarde) {
        Chargement chargement = null;
        switch (typeSauvegarde) {
            case 1:
                chargement = new ChargementXML();
                break;
            case 2:
                chargement = new ChargementMariaDB();
                break;
            case 3:
                chargement = new ChargementMongoDB();
                break;
        }
        return chargement;
    }
}
