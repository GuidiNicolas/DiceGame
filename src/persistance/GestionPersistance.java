package persistance;

import diceGame.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Nicochu on 18/11/2016.
 */
public class GestionPersistance {

    public static void sauvegarder(Object o) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        session.save(o);
        tx.commit();
        session.clear();
    }

    public static void supprimer(Object o) {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        session.delete(o);
        tx.commit();
        session.clear();
    }



    // Fonctions de requêtes \\

    public static List<Player> listeAbonnes() {
        return HibernateUtil.currentSession().createQuery("from Player").getResultList();
    }

    // Fonctions d'ajouts \\

    public static void ajouterPlayer(Player player)
    {
        sauvegarder(player);
    }
}
