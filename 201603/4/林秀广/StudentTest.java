package com.s126.Dao;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

import com.s126.Util.HibernateUtil;
import com.s126.bean.Student;
import com.s126.bean.Teacher;

public class StudentTest extends HibernateUtil{

	
	@Test
	public  void save() {
		Student student = new Student();
		Teacher teacher = new Teacher();
		student.setStudentname("张三");
		teacher.setTeachername("老牛");
		student.getTeachers().add(teacher);
		teacher.getStudents().add(student);
		session.save(student);
		session.save(teacher);
		session.beginTransaction().commit();
		session.clear();
	}
	@Test
	public void select() {
		Query query = session.createQuery("from Student");
		List <Student> list =query.list();
		for(Student i : list){
			System.out.print(i);
		}
		session.clear();
	}
 	public static void main(String[] args) {
		printddl();
	}
}
