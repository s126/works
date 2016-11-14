package s126.hello.service;

import java.util.List;

import s126.hello.bean.Students;
import s126.hello.dao.StudentDao;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	public boolean addStudent(Students students) {
		return studentDao.addStudent(students);
	}
	
	public List<Students> getStudents() {
		return studentDao.getStudents();
	}
}
