package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Account;
import s126.hello.util.DBUtil;
import s126.hello.util.HibernateUtil;


public class LoginDao extends BaseDao {
	
	/**
	 * 增加一个新的账号.
	 */
	public boolean addAccount(Account account) {
		Session session = null;
		Transaction transaction = null;
		try {
			// 获取 session， 开启事务
			// 放在最前面
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			// 执行保存
			session.save(account); 
			
			// 事务的提交
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
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
	 * @param username
	 * @param password
	 */
	@SuppressWarnings("unchecked")
	public List<Account> checkLogin(String username, String password) {
		
		Session session = HibernateUtil.getSession();
		List<Account> acclist = session.createQuery("from Account where username=? and password=?").setString(0, username).setString(1, password).list();
		session.close();
		
		return acclist;
	}


	/**
	 * 检查用户名是否已经存在
	 * @param username
	 */
	public boolean checkEname(String username) {
		return query(Account.class, "select username from account where username = ?", username).size() > 0;
	}
	
}
