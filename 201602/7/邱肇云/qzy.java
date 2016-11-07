package s126.hello.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HBUtil {
	
	private static SessionFactory sessionFactory;
	public static Session openSession(){
		
		//初始化 configuration 对象，用来加载并解析 hibernate 的配置文件
		//Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		Configuration config = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()//
				.applySettings(config.getProperties()).build();
		//编程是配置，也叫动态加载实体类的映射
		//config.addAnnotatedClass(Account.class);
		//config.addResource("Account.hbm.xml");
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		//创建一个新的session对象
		Session session = sessionFactory.openSession();
		
		return session;
	}	
}


///EmpDao.java

package s126.hello.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TextEmpDao {
	

	@SuppressWarnings("unchecked")
	public List<String> getJobs() {
		
		Session session = HBUtil.openSession();
		
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from emp");
		List<String> StringList = query.list();
		transaction.commit();
		session.close();
		
		return StringList.size()>0 ? StringList : null;
	}	
}


////ItemsDao.java



package s126.hello.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Item;

public class TextItemsDao {
	
	@SuppressWarnings("unchecked")
	public List<Item> getByStatus(int status) {
		
		Session session = HBUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from items_info where status = ?").setInteger(0,status);
		
	
		List<Item> ItemList = query.list();
		transaction.commit();
		session.close();
		
		
		return ItemList.size()>0 ? ItemList:null;
	}
}
