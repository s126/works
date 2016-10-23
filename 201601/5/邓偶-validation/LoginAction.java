package com.s126.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.s126.bean.Account;
import com.s126.dao.LoginDao;

public class LoginAction  extends ActionSupport{
	
	
	private String name;
	private String pwd;
	private Account acc = null;
	
	
	//实例化一个LoginDao对象
	private LoginDao loginDao = new LoginDao();
	
	/**
	 * 注册
	 * */
	public String register () {
		//注册用户并返回结果,成功?success:faile
		if(loginDao.addAccount(acc))
			return "success";
		return "fails";
	}

	/**
	 * 注册验证Validation方法
	 * */
/*	public void validateRegister() {
		if(acc.getUsername() == null || acc.getUsername().isEmpty())
			addFieldError("acc.username","账号不能为空");
		if(acc.getPassword() == null || acc.getPassword().isEmpty())
			addFieldError("acc.password","密码不能为空");
	}
	*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}


	

}
