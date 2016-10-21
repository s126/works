package com.nf.entity;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
	
	private String name;
	private String password;
	private int sex;
	private int acctype;         
	private Date lastLogin;      
	private Date birthday;       
	private String email;
	private String photonum;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAcctype() {
		return acctype;
	}
	public void setAcctype(int acctype) {
		this.acctype = acctype;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotonum() {
		return photonum;
	}
	public void setPhotonum(String photonum) {
		this.photonum = photonum;
	}
	
	
	

	
	
	
	

	

	
	
	
}
