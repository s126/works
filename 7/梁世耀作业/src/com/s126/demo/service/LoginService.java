package com.s126.demo.service;

import com.s126.demo.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao = new LoginDao();
	
	public void login(String name, String pwd) {
		loginDao.checkLogin(name, pwd);
	}
}
