package com.s126.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.s126.entity.Student;
import com.s126.entity.Teacher;

public class TeacherDao {
	private Session session;
	Transaction transaction;
	public List<Teacher> selectTeacher(){
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Teacher");
			
			List<Teacher> list = query.list();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		return null;
	}
	
	public boolean addStuAndTea(Student s,Teacher t){
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			s.getTeacher().add(t);
			t.getStudent().add(s);

			session.save(s);
			session.save(t);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
			return false;
		}finally{
			session.close();
		}
	}
}	
