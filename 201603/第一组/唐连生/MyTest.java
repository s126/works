package many2Many;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;


public class MyTest {
	
	Configuration config = new Configuration().configure("/many2Many/hibernate.cfg.xml");
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();



	@Test
	public void testSave(){


		
		
		Teacher teacher1 = new Teacher();
		teacher1.setTname("zhangsan");
	
		Teacher teacher2 = new Teacher();
		teacher2.setTname("lisi");
		
		
		Student student1 = new Student();
		student1.setName("wnagwu");
	
		Student student2 = new Student();
		student2.setName("zaoliu");
		
		student1.getTeacher().add(teacher1);
		teacher1.getStudent().add(student1);
		
		student2.getTeacher().add(teacher2);
		teacher2.getStudent().add(student2);
		
		session.save(teacher1);
		session.save(student1);
		session.save(teacher1);
		session.save(student1);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	
		
	}
	
	
	@Test
	public void testGet(){
		
		@SuppressWarnings("unchecked")
		List<Teacher> list = session.createQuery("from Teacher").list();
		
		for(Teacher teacher:list){
			System.out.println(teacher);
		}
		
		session.close();
		
	}
	


	
	
}





