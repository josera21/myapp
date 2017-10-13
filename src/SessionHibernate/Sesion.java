package SessionHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Sesion {
	private static final SessionFactory sessionFactory;
    
	static {
		try {
			sessionFactory = new Configuration().configure(("hibernate.cfg.xml"))
					.buildSessionFactory();
		} catch (Throwable ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
