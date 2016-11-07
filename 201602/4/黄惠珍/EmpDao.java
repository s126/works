package s126.hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.util.HibernateUtil;

public class EmpDao extends HibernateUtil {
	Session session = null;
	Transaction transaction = null;
	
	@SuppressWarnings("unchecked")
	public List<String> getJobs() {
		List<String> list = new ArrayList<String>();
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			list =session.createQuery("select distinct job from emp").list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
