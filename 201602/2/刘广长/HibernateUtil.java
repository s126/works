package com.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	
	static {
		try {
			Configuration configuration = new Configuration().configure();
			//configuration.configure("/hibernate.cfg.xml");
			System.out.println("Hibernate Configuration loaded");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate serviceRegistry created");
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			System.out.println("Hibernate SessionFactory success");
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> listByHql(String hql,Object...object){
		List<T> list = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery(hql);
			if(object!=null && object.length>0){
				for(int i=0;i<object.length;i++){
					query.setParameter(i,object[i]);
				}
			}
			list=query.list();
		} catch (Exception e) {
			
		}finally{
			if(session!=null)
			session.close();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean saveObject(Object entity) {
		boolean b = false;
		Transaction transaction=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(entity);
			b =true;
		} catch (Exception e) {
			if(e != null){
				transaction.rollback();
			}
			throw e;
		}finally {
			if(session!=null)
				if(session!=null)
					session.close();
		}
		return b;
	}
	
	public static boolean delObject(Object entity) {
		boolean b = false;
		Transaction transaction=null;
		Session session=null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
			b =true;
		} catch (Exception e) {
			if(e != null)
				transaction.rollback();
		} finally {
			if(session!=null)
				if(session!=null)
					session.close();
		}
		return b;
	}
	
	public static boolean updateObject(Object entity) {
		boolean b = false;
		Transaction transaction=null;
		Session session=null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			b =true;
		} catch (Exception e) {
			if(e != null)
				transaction.rollback();
		} finally {
			if(session!=null)
				session.close();
		}
		return b;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getObjectById(Class<T> clazz,int id) {
		T object = null;
		Session session=null;
		session = HibernateUtil.getSession();
		object = (T) session.get(clazz, id);
		return object;
	}

}
