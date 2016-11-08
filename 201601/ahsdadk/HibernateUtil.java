package s126.hello.util;  
      
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;  
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;  
      
public class HibernateUtil {  
	public static SessionFactory sessionFactory = null;
	private static String cfgpath="/s126/hello/dao/hello.cfg.xml";
	
	static{
		Configuration config = new Configuration().configure(cfgpath);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}  

