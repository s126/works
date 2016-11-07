package s126.hello.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import s126.hello.bean.AccType;
import s126.hello.bean.Account;
import s126.hello.util.DBUtil;


public class LoginDao extends BaseDao {
	private SessionFactory sessionFactory ;
	private Session session;
	Transaction transaction = null;
	// 初始化加载配置对象
	Configuration config = new Configuration().configure("hello.cfg.xml");
	// 初始化服务
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	// 初始化 SessionFactory
	sessionFactory = config.buildSessionFactory(serviceRegistry);
	
	
	
	/**
	 * 增加一个新的账号.
	 */
	public boolean addAccount(Account account) {
		
		
		boolean bl = false; 
		try {
			
			session = sessionFactory.openSession();
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
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			List<AccType> list =session.createQuery("from AccType").list();
			
			for(AccType t : list) {
				map.put(t.getTid(), t.getTname());
			}
			
			transaction.commit();
			session.close();
		} catch (SQLException e) {
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
		String sql = "select username, acctype, lastlogin from account where username=? and password=?";
		List<Account> accs = query(Account.class, sql, username, password);
		if(accs.size() > 0)
			return accs.get(0);
		return null;
	}


	/**
	 * 检查用户名是否已经存在
	 * @param username
	 */
	public boolean checkEname(String username) {
		return query(Account.class, "select username from account where username = ?", username).size() > 0;
	}
	
}
