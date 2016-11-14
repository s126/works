package s126.hello.Dao1;

import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import s126.hello.bean.Account;
public class AccountDao {
	public boolean insertAll(Object obj){
		Session session=HibernateUtils.openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			session.save(obj);
			tx.commit();
			return true;
		}catch(RuntimeException e){
			if(tx!=null) 
				tx.rollback();
			return false;
		}finally{
			if(tx!=null)	
				session.close();
		}
	}
	
	public <T> List<T> findAll(String hql) {
		Session session= HibernateUtils.openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			@SuppressWarnings("unchecked")//被批注的代码元素内部的某些警告保持静默
			List<T> list=session.createQuery(hql).list();
			tx.commit();
			return list;
		}catch(RuntimeException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public static void main(String[] args) throws Exception {
		List<Account> list = new AccountDao().findAll("FROM emp");
		System.out.println(list.size());
		for( Account a: list){
			System.out.println(a.toString());
		}
	}
}
