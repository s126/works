package com.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.user.dao.RegistDao;

public class RegistAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int u_num; 
	private String u_name;
	private String u_password;
	private String u_email;
	private String u_phone;
	private String u_sex;
	private boolean bl;
	
	
	public String regist(){
		bl = new RegistDao().regist(u_num, u_name, u_password,u_email,u_phone,u_sex);
		if(bl){
			return "success" ;
		}else{
			return "false";
		}
	}

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

	public boolean isBl() {
		return bl;
	}

	public void setBl(boolean bl) {
		this.bl = bl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
