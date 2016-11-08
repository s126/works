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
	
	
	/**
	 * 获取所有job
	 * @return 所有job的String集合
	 * */
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
	
	
//	public List<String> getJobs() {
//		List<String> list = new ArrayList<String>();
//		String sql = "select distinct job from emp";
//		try {
//			conn = DBUtil.getConn();
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				rs.getString(1);
//				list.add(rs.getString(1));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	
	
	
	/**获取所有员工信息
	 * @return 数据库中所有的Emp对象集合
	 * */
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
	
	
	/**筛选；like搜索
	 * @return 符合条件的Emp对象集合
	 * */
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
	
	
	/**添加员工
	 * @return 是否成功 boolean
	 * */
	public boolean addEmp(Emp emp){
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
			return true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**删除员工
	 * @return 是否成功 boolean
	 * */
	public boolean deleteEmp(int empno){
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			query = session.createQuery("delete from Emp where empno=?");
			query.setInteger(0, empno);
			int count = query.executeUpdate();
			transaction.commit();
			return count>0;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	
	/**根据工资范围筛选
	 * @return 符合调剂按的Emp对象集合
	 * */
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
