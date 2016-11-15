package s126.hello.dao;
import java.util.List;

import org.hibernate.Session;

import s126.hello.bean.Students;
import s126.hello.bean.Teacher;
import s126.hello.util.HibernateUtil;

public class STDao {
	
	/***
	 * 查询所有老师
	 */
	public List<Teacher> getAll(){
		Session session = HibernateUtil.getSession();
		List<Teacher> list = session.createQuery("form Teacher").list();
		session.close();
		return list;
	}
	
	/***
	 * 插入老师
	 */
	public boolean add(Students stus,Teacher teachers){
		Session session = HibernateUtil.getSession();
		Students sts = new Students();
		sts.setStus(stus.getStus());
		sts.setQQ(stus.getQQ());
		
		Teacher teas = new Teacher();
		teas.setTername(teachers.getTername());
		teas.setTel(teachers.getTel());
	
		teas.getStus().add(sts);
		sts.getTeachers().add(teas);
		
		session.save(stus);
		session.save(teas);
		session.close();
		return true;
	}
	
	

}
