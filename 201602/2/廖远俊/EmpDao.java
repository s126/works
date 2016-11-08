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
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import s126.hello.bean.Emp;
import s126.hello.util.HibernateUtil;


public class EmpDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public static List<String> getJobs(){	
		SessionFactory sessionFactory = null; 
			HibernateUtil  HibernateUtil = new  HibernateUtil();
			Session session = HibernateUtil.getSession();			
			Query quert = session.createQuery("from Emp");
			List<String> listEmp = quert.list();		
			session.close();	
			return listEmp;		
	
	
		
	}
	public static void main(String[] args) {
		 List<String> list = getJobs();
		 System.out.println(list);
	}
	
	
	
	

}
