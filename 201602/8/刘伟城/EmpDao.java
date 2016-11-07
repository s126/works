package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Emp;
import s126.hello.util.DBUtil;
import s126.hello.util.HibernateUtil;

public class EmpDao extends BaseDao {

	public List<String> getJobs() {
		
		Session session = HibernateUtil.getSession();
		List<String> jobs = session.createQuery("select distinct job from Emp").list();
		session.close();
		return jobs;
	
	}

	public List<Emp> getAll() {
		return (List<Emp>)HibernateUtil.getSession().createQuery("from Emp").list();
	}

	public List<Emp> getSome(String input) {
		String cond = "%" + input + "%";
		String sql = "from Emp where upper(ename) like upper(?) or upper(job) like upper(?)";
		
		return (List<Emp>)HibernateUtil.getSession().createQuery(sql).setString(0, cond).setString(1, cond).list();
	}

	public boolean add(Emp emp) {
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(emp);
			
			transaction.commit();
			return true;
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
	}

	public boolean delete(int empno) {
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Emp emp = (Emp) session.get(Emp.class, empno);
			session.delete(emp);
			
			transaction.commit();
			return true;
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
	}

	public List<Emp> getBySalRange(int min, int max) {
		String sql = "from Emp where sal>=? and sal<=?";
		
		return (List<Emp>)HibernateUtil.getSession().createQuery(sql).setInteger(0, min).setInteger(1, max).list();
		
	}

}
