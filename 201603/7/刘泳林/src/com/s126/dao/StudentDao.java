package com.s126.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s126.entity.Student;
import com.s126.entity.Teacher;

public class StudentDao {
	/*@Test
	public void add(){
		Student s1 = new Student("泳哥","男",18);
		Student s2 = new Student("泳哥","男",18);
		Student s3 = new Student("泳哥","男",18);
		Student s4 = new Student("泳哥","男",18);

		Teacher t1 = new Teacher("老马","java","男");
		Teacher t2 = new Teacher("易微","班主任","女");
		Teacher t3 = new Teacher("老牛","Anroid","男");

		t1.getStudent().add(s1);
		t1.getStudent().add(s2);
		t2.getStudent().add(s3);
		t3.getStudent().add(s4);
		
		s1.getTeacher().add(t1);
		s2.getTeacher().add(t1);
		s3.getTeacher().add(t2);
		s4.getTeacher().add(t3);

		session.save(t1);
		session.save(t2);
		session.save(t3);
	}
	@Test
	public void selectall(){
		String hql ="from Student";
		
		Query query = session.createQuery(hql);
		
		List<Student> list = query.list();
		
		for (Student s : list) {
			System.out.println(s.getName());
			System.out.println(s.getTeacher().toString());
		}
	}
	*/
	public List<Student> selectAll(){
		Session session = HibernateUtil.getSession();
		List<Student> list;
		Transaction transaction = session.beginTransaction();
		
		try {
			Query query = session.createQuery("from Student");
			
			list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		return null;
	} 
	
	public static void main(String[] args) {
		List<Student> list= new StudentDao().selectAll();
		
		for (Student s : list) {
			System.out.println(s.getName());
		}
	}
	
}
