package com.entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;


public class Test {
	public static void main(String[] args) {
		add();   //����
		//query();  //��ѯ
	}
	public static void add() {  //����
		Teacher_entity g = new Teacher_entity("��ţ","java��Ŀ");
		Student_entity s = new Student_entity("邱肇云","��",120,"S3Sj126");
	
		g.getStudents().add(s);
	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();//����
		session.save(g);
		session.save(s);
		tx.commit();
		HibernateUtil.closeSession(session);
		
	}
	
	public static void  query() {  //��ѯ
		Session session = HibernateUtil.getSession();
		Teacher_entity grade = (Teacher_entity) session.get(Teacher_entity.class, 1);
		
		Set<Student_entity> students = grade.getStudents();
		for(Student_entity  stu:students) {
			System.out.println(stu.getSname()+","+stu.getSex()+","+stu.getScore()+","+stu.getRemove());
		}
	}
}
