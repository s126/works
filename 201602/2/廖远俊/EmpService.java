package s126.hello.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import s126.hello.bean.Emp;
import s126.hello.dao.EmpDao;
import s126.hello.util.HibernateUtil;

public class EmpService {

		private  EmpDao empDao = new EmpDao();	
		private static Query quert = null;
		private static Transaction transaction = null;
		private static SessionFactory sessionFactory = null;
		private static Session session = null;
		private static HibernateUtil  HibernateUtil = new  HibernateUtil();
		
	@SuppressWarnings({ "unchecked", "static-access" })
	public static  List<Emp> getAll() {
			session = HibernateUtil.getSession();
			quert = session.createQuery("from Emp ");
			List<Emp> listEmp = quert.list();
			session.close();
			return listEmp;		

	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public static  List<Emp> getSome(String input) {
		session = HibernateUtil.getSession();
		String sql = "select empno, ename, job, sal from Emp where upper(ename) like upper('%"+input+"%') or upper(job) like upper('%"+input+"%')";		
		Query quert = session.createSQLQuery(sql).addEntity(Emp.class);
		List<Emp> list = quert.list();
		session.close();
		return list;
	}

	@SuppressWarnings("static-access")
	public static  boolean add(Emp emp) {		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			transaction.commit();
			session.close();
			sessionFactory.close();
		}
		return true;

	}

	@SuppressWarnings("static-access")
	public  boolean delete(int empno) {			
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Emp emp = (Emp) session.get(Emp.class, empno);
			session.delete(emp);					
		} catch (IllegalArgumentException e) {
			e.getStackTrace();
		}finally{
			transaction.commit();
			session.close();
			sessionFactory.close();
		}		 
		return true;
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public  List<Emp> getBySalRange(int min, int max) {
		 session = HibernateUtil.getSession();
		 String sql = "select empno, ename, job, sal from Emp where sal>="+min+" and sal<="+max+" ";		
		 Query quert = session.createSQLQuery(sql).addEntity(Emp.class);
		List<Emp> list = quert.list();		
		session.close();
		return list;
	}


	@SuppressWarnings("static-access")
	public List<String> getJobs() {
		System.out.println(empDao.getJobs());
		return empDao.getJobs();
	}



}
