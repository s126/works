package s126.hello.service;

import java.util.List;

import s126.hello.bean.Emp;
import s126.hello.dao.EmpDao;

public class EmpService {

	private EmpDao empDao = new EmpDao();
	
	public List<Emp> getAll() {
		String sql = "select empno, ename, job, sal from Emp";
		return empDao.query(Emp.class, sql);
	}
	
	public List<Emp> getSome(String input) {
		String cond = "%" + input + "%";
		String sql = "select empno, ename, job, sal from Emp where upper(ename) like upper(?) or upper(job) like upper(?)";
		return empDao.query(Emp.class, sql, cond, cond);
	}

	public boolean add(Emp emp) {
		return empDao.execute(
				"insert into emp (ename,job,sal) values (?, ?, ?)",
				emp.getEname(), emp.getJob(), emp.getSal());
	}

	public boolean delete(int empno) {
		String sql = "delete from Emp where empno=?";
		return empDao.execute(sql, empno);
	}

	public List<Emp> getBySalRange(int min, int max) {
		String sql = "select empno, ename, job, sal from Emp where sal>=? and sal<=?";
		return empDao.query(Emp.class, sql, min, max);
	}


	public List<String> getJobs() {
		return empDao.getJobs();
	}

}
