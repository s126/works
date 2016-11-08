package com.user.bean;

public class UserBean {
	 private int u_num;
     private String u_name;
     private String u_password;
     private String u_email;
     private String u_phone;
     private String u_sex;
     private int u_identity;//1，服务员 2，部长，领班 3、经理  4董事，老板
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public int getU_identity() {
		return u_identity;
	}
	public void setU_identity(int u_identity) {
		this.u_identity = u_identity;
	}
	@Override
	public String toString() {
		return "UserBean [u_num=" + u_num + ", u_name=" + u_name + ", u_password=" + u_password + ", u_identity="
				+ u_identity + "]";
	}
     
     
}
