package s126.hello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Student;
import s126.hello.util.HibernateUtil;

public class StudentDao {

	
	/**
	 * 添加一个学生
	 */
	public boolean addStudent(Student student) {

		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(student);
			
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
	 * 获取所有学生
	 */
	public List<Student> getStudents() {
	
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
	 * 根据教室 获取所有学生
	 */
	public List<Student> getStudentsBycrid(int crid) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			return (List<Student>)session.createQuery("from Student s where s.classroom=?").setInteger(0, crid).list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static void main(String[] args) {
		List<Student> studentsBycrid = new StudentDao().getStudentsBycrid(1);
		for (Student student : studentsBycrid) {
			System.out.println(student);
		}
	}
}
