package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Emp;
import s126.hello.util.DBUtil;

public class EmpDao extends BaseDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	Session session;
	Transaction transaction;
	Query query;
	List<Emp> emps;
	
	
	
	public List<String> getJobs(){
		try{
			List<String> jobs = new ArrayList<String>();
			session = DBUtil.getSession();
			jobs = session.createQuery("select JOB from Emp").list();
			return jobs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	


	
	
	

	public List<Emp> getAll(){
		try{	
			session = DBUtil.getSession();
			emps = session.createQuery("from Emp").list();
			return emps;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	
	
	public List<Emp> getSome(String input){
		try{
			session = DBUtil.getSession();
			query = session.createQuery("from Emp where upper(ename) like upper(?) or upper(job) like upper(?)");
			query.setString(0, input);
			query.setString(1, input);
			emps = query.list();
			return emps;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	

	public List<Emp> getBySalRange(int min, int max) {
		try{
			session = DBUtil.getSession();
			query = session.createQuery("from Emp where sal>=? and sal<=?");
			query.setInteger(0, min);
			query.setInteger(1, max);
			emps = query.list();
			return emps;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
}
