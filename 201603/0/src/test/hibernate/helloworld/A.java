package hibernate.helloworld;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class A {
	
	// 第一步，建立 Web 工程
	//
	// 第二步，将需要用到的 jar 包，拷贝到 lib 包的下面
	// 
	// 第三步，创建 hibernate 的配置文件 hibernate.cfg.xml，指定数据库信息、打印sql语句策略等
	//
	// 第四步，创建实体类 Book.java
	// 
	// 第五步，创建数据库跟实体类的映射。有两种方式：xml方式，annotation方式
	// 第 5.1 步，创建相关的xml映射文件 Book.hbm.xml
	// 第 5.2 步，在实体类上加相关的注解 @Entity/@Table/@Id/@GeneratedValue/@Column
	// 
	// 第六步，在 hibernate.cfg.xml 中添加映射，开始连接
	// 第 6.1 步，创建 sessionFactory
	// 第 6.2 步，创建 session
	// 第 6.3 步，创建 Transaction
	// 第 6.4 步，通过 Query 进行查询；通过 save/delete等方法进行增删。
	// 第 6.5 步，提交事务，关闭session。
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration config = new Configuration().configure("/hibernate/helloworld/hello.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();

		// 简单的插入
		Transaction transaction = session.beginTransaction();
		session.save(new Book("Java", 8888));
		
		System.out.println("------------------------");
		
		// 简单的查询
		Query query = session.createQuery("from Book");
		List<Book> booklist = query.list();
		
		System.out.println("++++++++++++++++++++++++");
		
		System.out.println(booklist);

		transaction.commit();
		session.close();
	}
}
