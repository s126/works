package s126.hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import s126.hello.bean.Account;
import s126.hello.bean.Emp;

public class empHibernateDao {
 
			
	//显示全部
	public List<Emp> findAll (String hql,Object...objs) {
		Session session = HibernateUtils.getSessionFactoru().openSession();
		Transaction tc = session.beginTransaction();
		List<Emp> emp = new ArrayList<Emp>();
		try {
			//这是使用hql语句的
			Query query = session.createQuery(hql);
			//这是使用sql语句的
			//Query query = session.createSQLQuery(hql).addEntity(Emp.class);
			if(objs!=null){
				//循环对象数组
				for (int i = 0; i < objs.length; i++) {
					query.setParameter(i, objs[i]);
				}
			}
			emp = query.list();
			tc.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tc.rollback();
		}finally{
			
			session.close();
		}
		return emp;
		
	}
	//增加
	public boolean add (Emp emp) {
		Session session = HibernateUtils.getSessionFactoru().openSession();
		Transaction tc = session.beginTransaction();
		
		try {
			session.save(emp);
			
			tc.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tc.rollback();
			return false;
		}finally{
			session.close();
			
		}
	}
	
	public Emp getEmp(int empno) {
		Emp emp = new Emp();
		Session session = HibernateUtils.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			emp = (Emp) session.get(Emp.class, empno);
			session.getTransaction().commit();
			}catch(RuntimeException e){
				if(tx!=null) {
					tx.rollback();//回滚事务
					e.printStackTrace();
				}
		}finally{
			if(tx!=null)
				session.close();//关闭session,释放资源
		}
		
		return emp;
	}
	
	/**
	 * 前提先获取他的对象
	 * 修改数据
	 * @param obj
	 */
	@Test
	public boolean update(Object obj) {
		Session session= HibernateUtils.openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			//操作
			session.update(obj);
			tx.commit();
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
	
	/**
	 * 前提先获取他的对象
	 * 删除对象
	 * @param obj
	 */
	public boolean delete(Object obj) {
		Session session= HibernateUtils.openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			//操作
			session.delete(obj);
			tx.commit();
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
	
	
	public static void main(String[] args) {
	/*	List<Emp> list = new empHibernateDao().findAll("select * from Emp where ename=?","ALLEN");
		for (Emp emp : list) {
			System.out.println(emp);
		}*/
		/*empHibernateDao eh= new empHibernateDao();
		Emp e = new Emp();*/
	/*	e.setEmpno(1);
		e.setEname("shdas");
		e.setJob("ssss");
		e.setSal(1000);
		eh.add(e);*/
		Session session= HibernateUtils.openSession();
		Transaction tc = session.beginTransaction();
		List<Account> accounts = new ArrayList<Account>();
		Query query = session.createQuery("From Account");
		accounts = query.list();
		System.out.println(accounts);
		tc.commit();
		session.close();
	}
	
}
