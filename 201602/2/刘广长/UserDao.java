package com.nf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nf.entity.Users;
import com.util.HibernateUtil;

public class UserDao {
	Session session =null; 
	Transaction transaction = null;

	public Users login(Users u) {
		Users user  =null;
		String hql = "from Users a where a.uname=? and a.upwd =?";
		user =(Users) HibernateUtil.listByHql(hql, u.getUname(),u.getUpwd()).get(0);
		return user;
	}

	
	public List<Users> showUsers() {
		List<Users> list = null;
		//String hql="select a.uid,a.uname,a.utype.tname from Users a inner join a.utype";
		String hql="from Users a";
		list=HibernateUtil.listByHql(hql);
		System.out.println("list:"+list.size());
		return list;
	}
	
	public Users getUsersById(int uid) {
		Users user=null;
		user = HibernateUtil.getObjectById(Users.class, uid);
		return user;
	}
	
	public boolean update(Users u) {
		Users user=null;
		boolean b =false;
		user = HibernateUtil.getObjectById(Users.class, u.getUid());
		System.out.println(user.getUname());
		if(user != null) {
			b=HibernateUtil.updateObject(user);
		}
		return b;
	}
	
	 
	public int regist(Users u) {
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(u);
			transaction.commit();
		} catch (Exception e) {
			if (e != null) {
				transaction.rollback();
				e.printStackTrace();
				return 0;
			}
		} finally {
			session.close();
		}
		return 1;
	}
}
