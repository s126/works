package s126.hello.Dao1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Account;

public class EmpDao {
	public <T> List<T> findAll(String hql) {
		Session session= HibernateUtils.openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<T> list=session.createQuery(hql).list();
			tx.commit();
			return list;
		}catch(RuntimeException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();//关闭session,释放资源
		}
	}
	public static void main(String[] args) throws Exception {
		List<Account> list = new AccountDao().findAll("select distinct job from emp");
		System.out.println(list.size());
		for( Account a: list){
			System.out.println(a.toString());
		}
	}
}
