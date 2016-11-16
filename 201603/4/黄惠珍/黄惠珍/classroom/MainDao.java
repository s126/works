package hibernate.demo.classroom;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainDao extends HibernateUtil{
	
	Session session = null;
	Transaction transaction = null;
	
	/**
	 * 增加一个学生
	 */
	public boolean addStudent(Student stu) {
		
		boolean bl = false; 
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(stu);
			
			transaction.commit();
			session.close();
			
			bl = true;
			
		} catch (Exception e) {
			transaction.rollback();
			bl = false;
			e.printStackTrace();
		} 
		
		return bl;
	
	} 
	
	/**
	 * 查询全部的学生
	 */
	public List<Student> QueryStu() {
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Student>)session.createQuery("from Student").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	/**
	 * 增加一个老师
	 */
	public boolean addTeacher(Teacher tea) {
		
		boolean bl = false; 
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(tea);
			
			transaction.commit();
			session.close();
			
			bl = true;
			
		} catch (Exception e) {
			transaction.rollback();
			bl = false;
			e.printStackTrace();
		} 
		
		return bl;
	
	}
	
	/**
	 * 查询全部的老师
	 */
	public List<Teacher> QueryTea() {
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Teacher>)session.createQuery("from Teacher").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	
	/**
	 * 增加一个班级
	 */
	public boolean addClassRoom(Classroom cla) {
		
		boolean bl = false; 
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(cla);
			
			transaction.commit();
			session.close();
			
			bl = true;
			
		} catch (Exception e) {
			transaction.rollback();
			bl = false;
			e.printStackTrace();
		} 
		
		return bl;
	
	}
	/**
	 * 查询全部的班级信息
	 */
	public List<Classroom> QueryClass() {
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Classroom>)session.createQuery("from Classroom").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
}
