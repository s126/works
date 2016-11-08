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
		try{//通过HibernateUtil获得会话
			session = HibernateUtil.getSession();
			List<String> list= session.createQuery("select job from emp").list();//创建查询语句
			 //返回list集合。
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}
	
}
