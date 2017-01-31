import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    public static final ThreadLocal session = new ThreadLocal();

    public static final SessionFactory sessionFactory1;

    //public static final SessionFactory sessionFactory2;

    static {
        try {
            sessionFactory1 = new Configuration().configure("/main/resources/hibernate.cfg.mariaDB.xml").buildSessionFactory();
        } catch (HibernateException ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new RuntimeException("Problème de configuration : " + ex.getMessage());
        }
    }

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s == null) {
            s = sessionFactory1.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null)
            s.close();
    }

    public static SessionFactory getSessionFactory1() {   return sessionFactory1;  }

}
