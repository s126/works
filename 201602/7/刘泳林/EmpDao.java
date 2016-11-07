package s126.hello.dao;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;*/
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
/*
import s126.hello.util.DBUtil;*/
import s126.hello.util.HibernateUtil;

public class EmpDao extends BaseDao {

	public List<String> getJobs(){
		Session session = null;
		
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String sql  = "select job from emp";
			
			Query query = session.createQuery(sql);
			
			List<String> list = query.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}
	
}
