package s126.hello.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.AccType;
import s126.hello.bean.Account;
import s126.hello.util.HibernateUtil;


public class LoginDao extends HibernateUtil {
	Session session = null;
	Transaction transaction = null;
	
	/**
	 * 增加一个新的账号.
	 */
	public boolean addAccount(Account account) {
		
		
		boolean bl = false; 
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(account);
			
			transaction.commit();
			session.close();
			
			bl = true;
			
		} catch (Exception e) {
			transaction.rollback();
			bl = false;
			e.printStackTrace();
		} 
		
		return bl;
	}

	
	/**
	 * 获取所有的身份类型，学生、老师等
	 */
	public Map<Integer, String> getAccTypes() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<AccType> list =session.createQuery("from AccType").list();
			
			for(AccType t : list) {
				map.put(t.getTid(), t.getTname());
			}
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		return map;
	}


	/**
	 * 获取的登录账号
	 * @param username
	 * @param password
	 */
	public Account checkLogin(String username, String password) {
		
		/*String sql = "select username, acctype, lastlogin from account where username=? and password=?";
		List<Account> accs = query(Account.class, sql, username, password);
		if(accs.size() > 0)
			return accs.get(0);
		return null;*/
		
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Account> acclist = session.createQuery("from Account where username=? and password=?").setString(0, username).setString(1, password).list();
		session.close();
		
		return acclist.size() > 0 ? acclist.get(0) : null;
		
		
		
	}


	/**
	 * 检查用户名是否已经存在，
	 * @param username
	 */
	public boolean checkEname(String username) {
		
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Account> acclist = session.createQuery("from Account where username=? ").setString(0, username).list();
		session.close();
		return acclist.size() > 0;
	}
	
}
