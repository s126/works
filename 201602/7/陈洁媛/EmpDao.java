package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import s126.hello.bean.Emp;
import s126.hello.util.DBUtil;
import s126.hello.util.HibernateUtil;

public class EmpDao extends BaseDao {
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
	
	public List<String> getJobs() {
		Session session = HibernateUtil.getSession();
		List<String> stringList = session.createQuery("select distinct job from Emp").list();
		session.close();
		return stringList;
	}
	
	
	public static void main(String[] args) {
		
		EmpDao p = new EmpDao();
		List<String> jobs = p.getJobs();
		for (String string : jobs) {
			System.out.println(string);
		}
		
	}

}
