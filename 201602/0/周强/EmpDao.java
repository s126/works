package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import s126.hello.bean.Emp;
import s126.hello.util.DBUtil;

public class EmpDao extends BaseDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;

	@SuppressWarnings("unchecked")
	public static List<String> getJobs() {
/*		List<String> list = new ArrayList<String>();
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
		return list;*/
		
		
		Configuration config = new Configuration().configure("/hibernate/helloworld/hello.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session	session = sessionFactory.openSession();		
		List<String> list = session.createSQLQuery("select * from emp").addEntity(Emp.class).list();
		
		session.close();
		sessionFactory.close();
		return list;
	}
	
	public static void main(String[] args) {
		List<String> list = getJobs();
		System.out.println(list);
		
	} 

}
