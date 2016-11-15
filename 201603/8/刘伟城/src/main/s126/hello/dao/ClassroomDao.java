package s126.hello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Classroom;
import s126.hello.util.HibernateUtil;

public class ClassroomDao {
	
	
	/**
	 *  添加一个教室
	 */
	public boolean addClassroom (Classroom classroom) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(classroom);
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
		
	}

	/**
	 * 获取所有教室
	 */
	public List<Classroom> getClassrooms() {
	
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Classroom>)session.createQuery("from Classroom").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public Classroom getClassroom(int cid) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (Classroom)session.createQuery("from Classroom c where c.crid=?").setInteger(0, cid).uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		Classroom classroom = new ClassroomDao().getClassroom(1);
		System.out.println(classroom);
	}
	
	
	
}
