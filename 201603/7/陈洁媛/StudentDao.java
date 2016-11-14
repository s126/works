package s126.hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import s126.hello.bean.Students;
import s126.hello.util.HibernateUtil;

public class StudentDao {
	
	/**
	 * 插入数据
	 * @param student
	 * @return
	 */
	public boolean addStudent(Students student){
		Transaction transaction = null; 
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			//????
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.clear();
		}
		
	}
	
	
	/*public List<Students> getStudents() {
		Session session = HibernateUtil.getSession();
		//Transaction tx = session.beginTransaction();
		String sql = "from Students";
		List<Students> itemList = session.createQuery(sql).list();
		session.close();
		return itemList;
	}*/
	
	public List<Students> getStudents() {
		List<Students> stus = new ArrayList<Students>();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			
			tx = session.beginTransaction();
			String sql = "from Students";
			Query query = session.createQuery(sql);
			stus = query.list();
			tx.commit();
			
		} catch(RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		
		
		return stus;
	}
	
	@Test
	public void testGetStudents() {
		StudentDao p = new StudentDao();
		List<Students> list = p.getStudents();
		for (Students student : list) {
			System.out.println(student);
		}
	}
	
	
	
}
