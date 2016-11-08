package com.nf.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.nf.dao.UserDao;
import com.nf.entity.Users;
import com.nf.entity.Utype;
import com.util.hbnUtil;

public class TestUsers {

	@Test
	public void initDB() {
		SessionFactory sessionFaction = hbnUtil.getSessionFactory();
		sessionFaction.close();
	}



	@Test
	public void regist() {
		Users u = new Users();
		Utype t = new Utype();
		t.setTid(1);
		t.setTname("学生");
		u.setUname("hehe");
		u.setUpwd("123");
		u.setUtype(t);
		
		int n = new UserDao().regist(u);
		System.out.println(n);
	}

	@Test
	public void showUsers() {
		List<Users> list = new UserDao().showUsers();
		
		for (Users u : list) {
			System.out.println(u.getUname());
		}
	}

	@Test
	public void login() {
		Users u = new Users();
		u.setUname("hehe");
		u.setUpwd("123");
		Users users = new UserDao().login(u);
		System.out.println("usrs：" + users.getUname());
	}

	@Test
	public void getUsersById() {
		Users user = new UserDao().getUsersById(22);
		System.out.println(user.getUname());
	}
	
	@Test
	public void update() {
		Users u = new Users();
		u.setUid(24);
		u.setUname("hehe");
		u.setUpwd("321");
		/*Utype t = new Utype();
		t.setTid(1);
		t.setTname("学生");*/
		boolean  b = new UserDao().update(u);
		System.out.println(b);
	}

}
