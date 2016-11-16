package s126.hello.service;

import org.apache.struts2.ServletActionContext;

import s126.hello.bean.Account;
import s126.hello.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao = new LoginDao();

	public boolean checkEname(String username) {
		return loginDao.checkEname(username);
	}

	public Account checkLogin(String username, String password) {
		return loginDao.checkLogin(username, password);
	}

	public Object getAccTypes() {
		return loginDao.getAccTypes();
	}

	public boolean addAccount(Account account) {
		return loginDao.addAccount(account);
	}

	public static void logout() {
		ServletActionContext.getRequest().getSession().invalidate();
	}
}




