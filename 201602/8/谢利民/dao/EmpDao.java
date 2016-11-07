package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

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
	
	@SuppressWarnings("unchecked")
	public List<String> getJobs() {
		Session session = HibernateUtil.getSession();
		List<String> stringlist = session.createQuery("select distinct job from emp").list();
		session.close();
		
		return stringlist;
	}
}
