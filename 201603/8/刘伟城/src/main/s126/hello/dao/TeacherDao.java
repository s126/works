package s126.hello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Classroom;
import s126.hello.bean.Teacher;
import s126.hello.util.HibernateUtil;

public class TeacherDao {
	
	
	/**
	 * 添加一个老师
	 */
	public boolean addTeacher(Teacher teacher) {
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(teacher);
			
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
	 * 获取所有老师
	 */
	public List<Teacher> getTeachers() {
	
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Teacher>)session.createQuery("from Teacher").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}


	public List<Teacher> getTeachersBycrid(int crid) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Teacher>)session.createQuery("from Teacher t where t.classroom=?").setInteger(0, crid).list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	
}
