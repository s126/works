package com.my.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		Configuration config = new Configuration().configure();
		ServiceRegistry sc = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				sessionFactory = config//
				.buildSessionFactory(sc);
	}

	/**
	 * 获取全局唯一的SessionFactory
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactoru() {
		return sessionFactory;
	}

	
	public static Session openSession() {
		return sessionFactory.openSession();
	}

}
