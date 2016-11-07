package s126.hello.service;

import java.util.List;

import hibernate.BaseTest;
import s126.hello.bean.Emp;
import s126.hello.dao.BaseDao;
import s126.hello.dao.EmpDao;

public class EmpService{
	
	private EmpDao empDao = new EmpDao();
	public List<Emp> getAll() {
		Session session= HibernateUtil.getSession();
		List<Emp> list = session.createSQLQuery("select empno, ename, job, sal from Emp").list();
		return list;
	}
	

	public boolean delete(Integer empno) {
		
		Session session= HibernateUtil.getSession();
		 String sql = "delete from Emp where empno=?";
		/*Query query = session.createQuery(sql);
		query.setInteger(0, empno);
		Boolean bl=query.executeUpdate()>0; */
		Boolean bl = session.createQuery(sql).setInteger(0, empno).executeUpdate()>0;
		session.close();
		return bl;
	
	}


	public boolean add(Emp emp) {
		Boolean bl = false;
		Session session= HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
		session.close();
		bl=true;
		
		return bl;

	}

	public List<Emp> getSome(String input) {
		Session session= HibernateUtil.getSession();
		String sql="select empno, ename, job, sal from Emp where upper(ename) like upper(?) or upper(job) like upper(?)";
		List<Emp> list = session.createQuery(sql).setString(0, input).setString(1,input).list();
		session.close();
		return list;
	}
	
	
	/*ÔÚempDaoÖÐ*/
	public List<String> getJobs() {
		return empDao.getJobs();
	}	

	public List<Emp> getBySalRange(int min, int max) {
		Session session= HibernateUtil.getSession();
		List<Emp> list = session.createQuery("select empno, ename, job, sal from Emp where sal>=? and sal<=?").setInteger(0, min).setInteger(1, max).list();
		return list;
	}
}
