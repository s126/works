package com.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.user.bean.UserBean;
import com.user.dao.LoginDao;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_num; 
	private String u_password;
	private UserBean user;
	
	private LoginDao loginDao = new LoginDao();
	
	/**
	 * 调用loginDao()，判断是否登录成功
	 * @return 登录结果
	 */
	public String login(){
		
		user = loginDao.login(u_num, u_password);
		if(user == null){
			return "fail";
		}
		ActionContext.getContext().getSession().put("user", user);
		return "success";	
	}

	public int getU_num() {
		return u_num;
	}

	public void setU_num(int u_num) {
		this.u_num = u_num;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
}
