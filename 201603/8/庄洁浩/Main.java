package hibernate.demo.homeword;


import java.util.List;

import org.junit.Test;

import hibernate.BaseTest;
import hibernate.demo.classroom.Classroom;

public class Main extends BaseTest{
	/**
	 * 插入数据
	 */
	@Test
	public void textSave(){
		Teacher t = new Teacher();
		t.setTname("易薇");
		
		Student s1 = new Student();
		s1.setSname("庄洁浩");
		s1.setTeacher(t);
		Student s2 = new Student();
		s2.setSname("张校花");
		s2.setTeacher(t);
		
		t.getStudents().add(s1);
		t.getStudents().add(s2);
		
		session.save(t);
		session.save(s1);
		session.save(s2);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void textSelectList(){
		List<Student> sList = session.createQuery("from Student").list();
		for(Student s: sList) {
			System.out.println(s.getSname());
		}
		
	}
}
