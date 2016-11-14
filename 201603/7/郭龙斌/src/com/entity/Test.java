package com.entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;


public class Test {
	public static void main(String[] args) {
		add();   //插入
		//query();  //查询
	}
	public static void add() {  //插入
		Teacher_entity g = new Teacher_entity("老牛","java科目");
		Student_entity s = new Student_entity("老郭","男",100,"S3Sj126");
	
		g.getStudents().add(s);
	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//事务
		session.save(g);
		session.save(s);
		tx.commit();
		HibernateUtil.closeSession(session);
		
	}
	
	public static void  query() {  //查询
		Session session = HibernateUtil.getSession();
		Teacher_entity grade = (Teacher_entity) session.get(Teacher_entity.class, 1);
		
		Set<Student_entity> students = grade.getStudents();
		for(Student_entity  stu:students) {
			System.out.println(stu.getSname()+","+stu.getSex()+","+stu.getScore()+","+stu.getRemove());
		}
	}
}
