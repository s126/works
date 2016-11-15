package com.my.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.my.entity.ClassRoom;
import com.my.entity.Teacher;
import com.my.entity.student;





public class HibernateDao {

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

	
	
	public <T> List<T> findAll (String hql,Object...objs) {
		Session session = HibernateUtils.getSessionFactoru().openSession();
		Transaction tc = session.beginTransaction();
		List<T> list = new ArrayList<T>();
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
			list = query.list();
			tc.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tc.rollback();
		}finally{
			
			session.close();
		}
		return list;
		
	}
	
	public List<ClassRoom> getclsRoom () {
		Session session = HibernateUtils.getSessionFactoru().openSession();
		Transaction tc = session.beginTransaction();
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		try {
			Query query = session.createSQLQuery("select * from ClassRoom");
			list = query.list();
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tc.rollback();
		}
		return list;
	}
	
	public static void main(String[] args) {
		/*student s = new student();
		s.setStu_birth(new Date());
		s.setStuname("sss");
		
		ClassRoom cls = new ClassRoom();
		cls.setClass_name("s127");
		cls.getStudents().add(s);
		s.setStu_cls(cls);
		boolean bl = new HibernateDao().Save(cls);
		if(bl)
			System.out.println("插入成功");*/
	/*	String sql = "From student";
		List<student> s = new HibernateDao().findAll(sql);
		for (student student : s) {
			System.out.println(student.getStuname()+".."+student.getStu_birth()+".."+student.getStu_cls().getClass_name());
		}*/
		/*String sql = "From ClassRoom";
		List<ClassRoom> cls = new HibernateDao().findAll(sql);
		for (ClassRoom classRoom : cls) {
			System.out.println(classRoom.getClass_name()+classRoom.getStudents());
		}*/
		HibernateDao h = new HibernateDao();
		List<ClassRoom> cls = h.getclsRoom();
		for (ClassRoom classRoom : cls) {
			System.out.println(classRoom);
		}
	}
	/*@Test
	public void testSave(){
		Session session = HibernateUtils.getSessionFactoru().openSession();
		Transaction tc = session.beginTransaction();
		
		student s = new student();
		s.setStu_birth(new Date());
		s.setStuname("hhh");
		
		Teacher t= new Teacher();
		t.setT_birth(new Date());
		t.setT_name("牛老师");
		
		ClassRoom cls = new ClassRoom();
		cls.setClass_name("s126");
		cls.getStudents().add(s);
		cls.getTeachers().add(t);
		
		s.setStu_cls(cls);
		t.setT_cls(cls);
		
		//session.save(s);
		session.save(cls);
		
		tc.commit();
		session.close();
	}	*/
}
