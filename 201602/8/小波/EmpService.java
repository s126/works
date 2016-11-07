package s126.hello.service;

import java.util.List;

import s126.hello.bean.Emp;
import s126.hello.dao.EmpDao;

public class EmpService {

	private EmpDao empDao = new EmpDao();
	
	public List<Emp> getAll() {
		return empDao.getAll();
	}
	
	public List<Emp> getSome(String input) {
		return empDao.getSome(input);
	}

	public boolean add(Emp emp) {
		return empDao.add(emp);
	}

	public boolean delete(int empno) {
		return empDao.delete(empno);
	}

	public List<Emp> getBySalRange(int min, int max) {
		return empDao.getBySalRange(min, max);
	}


	public List<String> getJobs() {
		return empDao.getJobs();
	}

}
