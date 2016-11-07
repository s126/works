package com.s126.demo.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.s126.demo.bean.Account;

import com.s126.demo.util.HibernateUtils;

public class LoginDao {

	/**
	 * 通过账号、密码查询账号，返回 account，查不到返回 null.
	 */
	/*public Account checkLogin(String name, String pwd) {
		Connection conn = DBUtil.getCon();
		String sql = "select username, acctype, lastlogin from account where username=? and password=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				account = new Account();
				account.setUsername(rs.getString(1));
				account.setAcctype(rs.getInt(2));
				account.setLastLogin(rs.getTimestamp(3));
			}
			
		} catch (Exception e) {
		}
		
		return account;
	}*/
	public Account checkLogin(String name, String pwd) {
		Session session = HibernateUtils.openSession();
		Transaction tx = null;
		Account account = null;
		try {
			tx = session.beginTransaction();
			session.createSQLQuery(name);
			session.createSQLQuery(pwd);
			session.save(name);
			session.save(pwd);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;
		
		
	}
	
	/**
	 * 增加一个新的账号.
	 */
	/*public boolean addAccount (Account account) {
		Connection conn = DBUtil.getCon();
		String sql = "insert into account (username, password, acctype, birthday) values (?, ?, ?, ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 事务处理
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getAcctype() == 0 ? 1 : account.getAcctype());
			ps.setDate(4, new Date(account.getBirthday().getTime()));
			ps.execute();
			
			conn.commit();
			
			return true;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
			
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
	}*/
	public boolean insertAll(Account account) {
		Session session = HibernateUtils.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(account);
			tx.commit();
			return true;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			return false;
		} finally {
			if (tx != null)
				session.close();
		}
	}
	public static void main(String[] args) {
		LoginDao loginDao = new LoginDao();
		System.out.println(loginDao.checkLogin("zhouqiang", "1234567"));
	}

}
