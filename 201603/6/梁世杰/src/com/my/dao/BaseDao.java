package com.my.dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.my.util.HibernateUtils;



public class BaseDao {
	
	
	/**
	 * 插入数据
	 * @param obj
	 */
	public boolean Save (Object obj) {
		Session session = HibernateUtils.getSessionFactoru().openSession();
		Transaction tc = session.beginTransaction();
		try {
			session.saveOrUpdate(obj);
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

	
	
	
	
	/**
	 * 查询有所
	 * @return
	 */
	public <T> List<T> findAll(String hql,Object...objs) {
		Session session= HibernateUtils.getSessionFactoru().openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			Query query = session.createQuery(hql);
			if (objs != null) {
				for (int i = 0; i < objs.length; i++) {
					query.setParameter(i, objs[i]);
				}
			}
			List<T> list=query.list();
			
			tx.commit();
			return list;
		}catch(RuntimeException e){
			tx.rollback();
			throw e;
		}finally{
			session.close();//关闭session,释放资源
		}
	}
	
	/**
	 * 根据ID查询对象 
	 * @param t
	 * @param id
	 * @return
	 */
	public <T> Object getById(Class clazz,int id) {
		Session session= HibernateUtils.openSession();
		Transaction tx=null;
		try{
			tx= session.beginTransaction();
			//操作
			Object obj=(T) session.get(clazz,id);
			tx.commit();
			return obj;
		}catch(RuntimeException e){
			
			tx.rollback();
			throw e;
		}finally{
			session.close();//关闭session,释放资源
		}
	}
	
	
	
	/**
	 * 修改数据
	 * @param obj
	 */
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
	
	public void close(Session session){
		if(session!=null)
			session.close();
	}
	
	
	
}

