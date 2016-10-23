package com.s126.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.s126.bean.Account;
import com.s126.dao.LoginDao;
import com.s126.dao.TypesDao;

public class LoginAction extends ActionSupport {

	private String name;
	private String pwd;
	private Account acc = null;
	private LoginDao loginDao = new LoginDao();
	private Map<String, String> maps = new HashMap<String, String>();

	/**
	 * 公用的验证方法。这个 Action 里面所有的请求方法，都会在执行前执行这个 validate
	 */
	/*
	 * @Override public void validate() {
	 * 
	 * // 这是一个 ActionError 的示例。 // addActionError("无缘无故的 Action 错误.");
	 * 
	 * if(name == null || name.isEmpty()) { addFieldError("name", "您的用户名不能为空。");
	 * } // 在这里写我们所有的公用验证逻辑。 System.out.println("helloWorld"); }
	 */

	/**
	 * 特定于 login 方法的验证,[这个是编程验证，声明验证在xml中配置]
	 */
	public void validateLogin() {
		if (name == null || name.isEmpty()) {
			addFieldError("name", "您的用户名不能为空。");
		}
		if (pwd == null || pwd.isEmpty()) {
			addFieldError("pwd", "密码太短。");
		}

		System.out.println("ok,local validate.");
	}

	/* 登录功能 */
	// 可以通过 InputConfig 注解，来指定，如果在 validate 方法中出现错误的话，那么跳转到哪个 result.
	@InputConfig(resultName = "input")
	public String login() {

		acc = loginDao.checkLogin(name, pwd);
		if (acc == null) {
			return "fail";
		}
		ActionContext.getContext().getSession().put("account", acc);
		return SUCCESS;

	}
   //到达注册页面
	public String registerIndex() {
		// 出事后处理
		maps = new TypesDao().allTypes();
		if (maps != null) {
			
			return SUCCESS;
		}
		return ERROR;
	}

	/* 注册功能 */
	public String register() {
		if (!loginDao.addAccount(acc))
			return "fails";
		return SUCCESS;
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

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	
}
