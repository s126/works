package test.action;

import java.util.Locale;

import com.opensymphony.xwork2.ActionSupport;

public class I18nAction extends ActionSupport{
	private String username = "张三";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
	}
}




