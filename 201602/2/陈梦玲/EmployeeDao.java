package work;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.helloworld.Employee;
import s126.hello.util.HibernateUtil;

public class EmployeeDao {
	
	public boolean add(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List getAll() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			List<Employee> emplist = query.list();
			transaction.commit();
			return emplist;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}			
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public boolean delete(int empno) {
		Session session = null;
		Transaction transaction = null;
		
		String sql = "delete from Employee where empno=?";
		try{
			session = HibernateUtil.getSession();
			Query query = session.createQuery(sql);
			Employee emp = (Employee) session.get(Employee.class, empno);
			session.delete(emp);
			return true;
		} catch (Exception e) {		
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
}
