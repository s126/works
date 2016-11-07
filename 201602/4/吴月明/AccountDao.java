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
			tx.commit();//提交事务
			return true;
		}catch(RuntimeException e){
			if(tx!=null) 
				tx.rollback();//回滚事务
			return false;
		}finally{
			if(tx!=null)	
				session.close();//关闭session,释放资源
		}
	}
	
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
		/*SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		Account a=new Account();
		a.setAcctype(1);
		a.setBirthday(sp.parse("2016-9-12"));
		a.setEmail("123456432");
		a.setLastLogin(sp.parse("2016-9-12"));
		a.setPassword("1234566");
		a.setPhone("adssa");
		a.setSex(1);
		a.setUsername("adggggg");
		boolean b1=new AccountDao().insertAll(a);
		System.out.println(b1);*/
		
		List<Account> list = new AccountDao().findAll("FROM Account where acctype=1");
		System.out.println(list.size());
		for( Account a: list){
			System.out.println(a.toString());
		}
	}
}
