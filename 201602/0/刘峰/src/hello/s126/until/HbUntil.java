package hello.s126.until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HbUntil {
	private static SessionFactory sessionFactory = null;
		static{
		// (1)初始化configuration对象.用来初始化Hibernate配置文件
		Configuration config = new Configuration().configure("Emp.cfg.xml");
		// (2)初始化服务
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// (3)初始化SessionFactory
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		// (4)获取会话对象。通过这一步进行数据库连接。接下来就可以通过这个对象进行与数据库的交互。
		}
		public static Session getSession(){
			Session session=sessionFactory.openSession();
			return session;
		}
	}

