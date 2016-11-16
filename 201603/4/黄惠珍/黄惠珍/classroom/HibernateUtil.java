package hibernate.demo.classroom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static String cfgpath = "/hibernate.cfg.xml";
	
	static {
		// 加载配置文件
		Configuration config = new Configuration().configure(cfgpath);
		// 初始化所有需要的服务
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// 创建 sessionFactory 对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);

	}
	
	public static Session getSession () {
		return sessionFactory.openSession();
	}

}
