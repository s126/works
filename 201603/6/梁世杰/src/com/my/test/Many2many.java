package com.my.test;

import java.util.List;

import org.junit.Test;

import com.my.bean.ClassRoom;
import com.my.bean.Student;
import com.my.bean.Teacher;
import com.my.dao.BaseDao;

public class Many2many {
	@Test
	public void Test(){
		ClassRoom c = new ClassRoom();
		c.setName("127");
		Student s1 = new Student();
		s1.setName("zss");
		s1.setSex(1);
		Student s2 = new Student();
		s2.setName("lss");
		s2.setSex(1);
		Teacher t1 = new Teacher();
		t1.setName("zls");
		t1.setSex(1);
		
		Teacher t2 = new Teacher();
		t2.setName("jmss");
		t2.setSex(1);
		s1.setClassRoom(c);
		s2.setClassRoom(c);
		t1.setClassRoom(c);
		t2.setClassRoom(c);
		c.getTeachers().add(t1);
		c.getTeachers().add(t2);
		c.getStudents().add(s1);
		c.getStudents().add(s2);
		BaseDao bd = new BaseDao();
		bd.Save(c);
		
		
		
	}
	@Test
	public void select(){
		BaseDao bd = new BaseDao();
		List<Student> stus =  bd.findAll("from Student");
		for (Student s : stus) {
			System.out.println(s.getName()+"..."+s.getClassRoom().getName());
//			System.out.println(c.getName());
		}
	}
	
}
