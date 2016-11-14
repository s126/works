package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

	public static SessionFactory sessionFactory = null;
	public static Transaction transaction = null;
	public static Session session = null;

	public static Configuration config = new Configuration().configure("/hibernate/student/hibernate.cfg.xml");;
	
	@BeforeClass
	public static void init() {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);

		// 处理业务的地
		// 首先要获取一个数据库连接，在 hibernate 中，是用 session 对象表示的这么个连接
		session = sessionFactory.openSession();

		// 事务处理
		transaction = session.beginTransaction();

	}
	
	@AfterClass
	public static void clean() {
		// 一定不要忘掉资源的关闭等
		// 1. flush
		// 2. commit
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	/**
	 * 打印 hibernate 生成表的 ddl 语句。
	 */
	public static void printddl() {
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, false);
	}

}
