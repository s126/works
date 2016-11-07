package com.s126.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.SessionFactoryOptions;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.s126.demo.bean.Emp;
import com.s126.demo.util.DBUtil;

public class EmpDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
   static Session session = null;
	/*
	 * public List<Emp> getAll() { List<Emp> ls = new ArrayList<Emp>(); String
	 * sql = "select ename, job, sal from Emp"; try { conn = DBUtil.getCon(); ps
	 * = conn.prepareStatement(sql); rs = ps.executeQuery(); while (rs.next()) {
	 * Emp emp = new Emp(); emp.setSal(rs.getInt("sal"));
	 * emp.setName(rs.getString("ename")); emp.setJob(rs.getString("job"));
	 * ls.add(emp); } } catch (Exception e) { e.printStackTrace(); } return ls;
	 * 
	 * }
	 * 
	 * public boolean delete(String ename) { boolean bl = false; sql =
	 * "delete from Emp where ename=?"; try { // 涓�瀹氳澧炲姞浜嬪姟澶勭悊 //
	 * conn.setAutoCommit(false); conn = DBUtil.getCon(); ps =
	 * conn.prepareStatement(sql); ps.setString(1, ename); bl =
	 * ps.executeUpdate() > 0; conn.commit();
	 * 
	 * } catch (Exception e) { try { conn.rollback(); } catch (SQLException e1)
	 * { e1.printStackTrace(); } e.printStackTrace(); } return bl;
	 * 
	 * }
	 */
	@SuppressWarnings("rawtypes")
	public static List getAll() {
		Transaction tx = null;
		List list = null;
		try {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		    session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from Emp order by sottp asd");
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		return list;
	}

	public static void delete(String name) {
		Transaction tx = null;
		SessionFactory HibernateUtil = null;
		try {
			Emp emp = new Emp();
			Session session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			session.delete(name);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

	

}
