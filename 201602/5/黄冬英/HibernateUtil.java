package com.demo.util;

import org.hibernate.Session;
 import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	       
	      /**
	       * @return 获取会话工厂
	      */
	        public static SessionFactory getSessionFactory()
	       {
	        	Configuration config = new Configuration().configure();
	    		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	    		
	    		sessionFactory = config.buildSessionFactory(serviceRegistry);

	         
	         return sessionFactory;
	        }
	        
	       /**
	        * @return 获取会话对象
	      */
	         public static Session getSession()
	        {
	           return getSessionFactory().openSession();
	        }
	  }

