package s126.hello.dao.copy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtils {
	// sessionFactorty全局只需要有一个就可以了
	private static SessionFactory sessionFactory;
	static {
//		 Configuration cfg = new Configuration();
//		 cfg.configure();//读取默认的配置文件(hilbernate.cfg.xml)
//		 cfg.configure("hilbernate.cfg.xml");读取指定位置的配置文件
//		 sessionFactory=cfg.buildSessionFactory();
		//初始化sessionFactory
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = new Configuration()//
				.configure("/s126/hello/dao/copy/HibernateTestDao.cfg.xml")//
				.buildSessionFactory();
	}

	/**
	 * 获取全局唯一的SessionFactory
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactoru() {
		return sessionFactory;
	}

	/**
	 * 从全局唯一的SessionFactory中打开一个Session
	 * 
	 * @return
	 */
	public static Session openSession() {
		return sessionFactory.openSession();
	}

}
