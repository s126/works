package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import hibernate.BaseTest;
import hibernate.helloworld.Book;
import s126.hello.util.DBUtil;

public class EmpDao extends BaseTest {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;

	/*public List<String> getJobs() {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct job from emp";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				rs.getString(1);
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}*/
	
	public List<String> getJobs(){
	
		
		Session session= HibernateUtil.getSession();
		List<String> list = session.createSQLQuery("select distinct job from Emp").list();
		session.close();
		return list;
		
	}
	

}
