package s126.hello.service;

import java.util.List;

import s126.hello.bean.Student;
import s126.hello.dao.StudentDao;

public class StudentService {
	
	
	
	private StudentDao studentDao = new StudentDao();

	public boolean addStudent(Student student) {
		
		return studentDao.addStudent(student);
	}

	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	public List<Student> getStudentsBycrid(int crid) {
		
		return studentDao.getStudentsBycrid(crid);
	}
}
