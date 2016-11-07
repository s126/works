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
import org.hibernate.Transaction;
import org.junit.Test;

import s126.hello.bean.Account;
import s126.hello.util.DBUtil;
import s126.hello.util.HibernateUtil;

public class LoginDao extends BaseDao {

	/**
	 * 增加一个新的账号.
	 */
	
	/*
	public boolean addAccount(Account account) {
		 String sql = "Account (username, password, acctype, birthday, email, phone, sex) values (?, ?, ? , ? , ? , ?, ? )";
		 String sql = "insert into account (username, password, acctype, birthday, email, phone, sex) values (?, ?, ? , ? , ? , ?, ? )";
		 return execute(sql,
				 account.getUsername(), account.getPassword(),
				 account.getAcctype() == 0 ? 1 : account.getAcctype(),
						 new Date(account.getBirthday().getTime()),
						 account.getEmail(), account.getPhone(), account.getSex());

	}
	*/
	
	public boolean addAccount(Account account) {
			Transaction transaction = null;
			Session session = null;
			try {
				session = HibernateUtil.getSession();
				transaction = session.beginTransaction();

				session.save(account);

				transaction.commit();
				return true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return false;
			} finally {
				session.close();
			}

		}

	/**
	 * 获取所有的身份类型，学生、老师等
	 */
	public Map<Integer, String> getAccTypes() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		String sql = "select tid, tname from types";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return map;
	}

	
	
	
	/**
	 * 获取的登录账号
	 * 
	 * @param username
	 * @param password
	 */
	
	/*
	public List<Account> checkLogin(String username, String password) {
		 String sql = "select username, acctype, lastlogin from account where
		 username=? and password=?";
		 List<Account> accs = query(Account.class, sql, username, password);
		 if(accs.size() > 0)
		 return accs.get(0);
	}
	*/
	
	public List<Account> checkLogin(String username, String password) {
		Session session = HibernateUtil.getSession();

		List<Account> acclist = null;
		String sql = "from Account where username=? and password=?";
		acclist = session.createQuery(sql).setString(0, username).setString(1, password).list();

		session.close();

		return acclist;
	}

	/**
	 * 检查用户名是否已经存在
	 * 
	 * @param username
	 */
	/*public boolean checkEname(String username) {
		return query(Account.class, "select username from account where username = ?", username).size() > 0;
	}*/
	
	public boolean checkEname(String username) {
		Session session = HibernateUtil.getSession();
		String sql = "from Account where username =?";
		Query name = session.createQuery(sql).setString(0, username);
		Account a = null;
		a = (Account) name.list().get(0);
		return a!=null ? true:false;
//		Boolean bl = name.executeUpdate()>0;
		
	}
	
	@Test
	public void testMain(){
		LoginDao p = new LoginDao();
		boolean b = p.checkEname("aaa");
		System.out.println(b);
	}

}
