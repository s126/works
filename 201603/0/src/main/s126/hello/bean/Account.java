package s126.hello.bean;

import java.util.Date;

public class Account {

	private String username;
	private String password;
	private int acctype; // 1, 学生； 2, 老师； 3, 校长
	private Date lastLogin; // 上次登录时间
	private Date birthday; // 生日
	private String email;
	private String phone;
	private int sex;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", acctype=" + acctype + ", lastLogin="
				+ lastLogin + ", birthday=" + birthday + ", email=" + email + ", phone=" + phone + ", sex=" + sex + "]";
	}

}
