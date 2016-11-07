package hello.s126.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import hello.s126.bean.Emp;
import hello.s126.until.HbUntil;

public class EmpDao {
	/**
	 * 判断用户是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Emp> emps(String username, String password) {
		Session session = HbUntil.getSession();
		String sql = "select username from emp where username=? and userword=?";
		Query query = session.createQuery(sql).setString(0, username).setString(1, password);
		session.beginTransaction().commit();
		List<Emp> list = query.list();
		session.close();
		return list.size() > 0 ? list : null;
	}

	/**
	 * 对对象进行添加事物
	 * 
	 * @param em
	 * @return
	 */
	public boolean addEmp(Emp em) {
		Session session = HbUntil.getSession();
		try {
			session.save(em);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		} finally {
			session.close();
		}
	}
}