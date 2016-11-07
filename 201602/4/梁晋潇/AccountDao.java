package com.s126.demo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.s126.demo.util.HibernateUtils;

public class AccountDao {
	
	public <T> List<T> findAll(String hql) {
		Session session = HibernateUtils.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<T> list = session.createQuery(hql).list();
			tx.commit();
			return list;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	//添加数据
	public boolean insertAll(Object obj) {
		Session session = HibernateUtils.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			return true;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			return false;
		} finally {
			if (tx != null)
				session.close();
		}
	}

	

	/*public static void main(String[] args) throws Exception {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		List<String> list = new AccountDao().findAll("select distinct job from Emp");
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
		}
	}*/
}
