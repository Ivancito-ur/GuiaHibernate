package guiahibernate.utilidad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static Session session;
	
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(/*hola*/);
		return sessionFactory;
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		if(null==session){
			session = sessionFactory.openSession();
		}
		return session;
	}

	
	
	
	

	
	
	

}
