package hibernate.ManyToMany;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import s126.hello.util.DBUtil;

/**
 * @author D.O
 * @version 创建时间：2016年11月11日 下午2:07:29
 * 简单说明
 */
public class Test1 {
	
	@Test
	public void TestManyToMany(){
	}

	public static void main(String[] args) {
		DBUtil.printddl();
	}
	
	
	@Test
	public void addTeacher(){
		Session session = null;
		Transaction transaction = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			Teacher teacher1 = new Teacher();
			teacher1.setName("张三");
			
			Teacher teacher2 = new Teacher();
			teacher2.setName("李四");
			
			session.save(teacher1);
			session.save(teacher2);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(transaction != null)
				transaction.rollback();
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	
	@Test
	public void addStudent(){
		Session session = null;
		Transaction transaction = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			
			Teacher zhangsan = new Teacher();
			zhangsan.setName("张三");
			
			Student stu1 = new Student();
			stu1.setName("小明");
			stu1.getTeachers().add(zhangsan);

			Student stu2 = new Student();
			stu2.setName("小黑");
			stu2.getTeachers().add(zhangsan);
			session.save(stu1);
			session.save(stu2);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(transaction != null)
				transaction.rollback();
		}finally{
			if(session != null)
				session.close();
		}
	}
	
	@Test
	public void queryTeacher(){
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			query = session.createQuery("from Teacher");
			List<Teacher> teachers = query.list();
			System.out.println(teachers);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
	}
	
	@Test
	public void queryStudent(){
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			query = session.createQuery("from Student");
			List<Student> students = query.list();
			System.out.println(students);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
	}
	
}

