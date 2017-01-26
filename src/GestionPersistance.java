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

    public static List<Abonne> listeAbonnesAvecLogin(String login) {
        return HibernateUtil.currentSession().createQuery("from Abonne as ab where ab.login = '"+login+"'").getResultList();
    }

    public static List<Abonne> listeAbonnes() {
        return HibernateUtil.currentSession().createQuery("from Abonne").getResultList();
    }

    public static List<Annuaire> listeAnnuaires() {
        return HibernateUtil.currentSession().createQuery("from Annuaire").getResultList();
    }

    public static Annuaire RecupererAnnuairesAvecNom(String nom) {
        return (Annuaire)HibernateUtil.currentSession().createQuery("from Annuaire as an where an.nom = '"+nom+"'").getResultList().get(0);
    }

    public static List<Entreprise> listeEntreprises() {
        return HibernateUtil.currentSession().createQuery("from Entreprise").getResultList();
    }

    public static List<Message> listeMessages() {
        return HibernateUtil.currentSession().createQuery("from Message").getResultList();
    }

    public static List<Particulier> listeParticuliers() {
        return HibernateUtil.currentSession().createQuery("from Particulier").getResultList();
    }

    public static List<Message> listeMessagesParLogin(String login) {
        return HibernateUtil.currentSession().createQuery("from Message as me where me.abonne.login = '"+login+"'").getResultList();
    }

    public static List<Entreprise> listeEntrepriseParAnnuaire(String nomAnnuaire) {
        return HibernateUtil.currentSession().createQuery("from Entreprise as en where en.annuaire.nom = '"+nomAnnuaire+"'").getResultList();
    }

    public static List<Particulier> listeParticulierParAnnuaire(String nomAnnuaire) {
        return HibernateUtil.currentSession().createQuery("from Particulier as pa where pa.annuaire.nom = '"+nomAnnuaire+"'").getResultList();
    }

    // Test de connexion \\

    public static boolean connexionValide (String login, String mdp) {
        List<Abonne> abonnes = listeAbonnesAvecLogin(login);

        if (abonnes.size() == 1) {
            if (abonnes.get(0).getMdp().equals(mdp)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Fonctions d'ajouts \\

    public static void ajouterAbonne(Abonne abonne)
    {
        sauvegarder(abonne);
    }
    public static void AjouterAnnuaire(Annuaire annuaire)
    {
        sauvegarder(annuaire);
    }
    public static void AjouterEntreprise(Entreprise entreprise)
    {
        sauvegarder(entreprise);
    }
    public static void AjouterMessage(Message message)
    {
        sauvegarder(message);
    }
    public static void AjouterParticulier(Particulier particulier) {
        sauvegarder(particulier);
    }

    public static void main (String[] args) {
        for (Annuaire an : listeAnnuaires()) {
            System.out.println(connexionValide("nicochu","nicochu"));
        }
    }
}
