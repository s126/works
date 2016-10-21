package com.nf.Action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
		
	private static final long serialVersionUID = 1L;
	private String email;
	private String phone;
	private String sex;
	
	
	
	public String index() {
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
