package action;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	private User user;
	private String name;
	private String pwd;
	private String Email; 
	private String phone;
	private int sex;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public String index(){
		return "success";
	}
	public String login(){
			return "success";
		}
	public void validateLogin(){
		System.out.println("Œ“‘⁄validate"+name);
	}
}
