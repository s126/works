package dao;

import com.opensymphony.xwork2.ActionSupport;

public class Yanzheng extends ActionSupport{
	public String Email;
	public int phone;
	public  String Sex;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
}
