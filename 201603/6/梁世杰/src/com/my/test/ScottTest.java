package com.my.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.my.bean2.Emp;
import com.my.util.HibernateUtils;

public class ScottTest {
	@SuppressWarnings("deprecation")
	@Test
	public void test(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Emp");
		Long rs = (Long) session.createQuery("select count(*) from Emp").uniqueResult();
		System.out.println(rs);
		List<Emp> emps = query.setFirstResult(5).setMaxResults(5).list();
		for (Emp emp : emps) {
			System.out.println(emp+"....."+emp.getDeptNo());
		}
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void test2(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Emp ");
		Emp emp = (Emp) query.uniqueResult();
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
	}
}
