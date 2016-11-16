package s126.hello.service;

import java.util.List;

import s126.hello.bean.Teacher;
import s126.hello.dao.TeacherDao;

public class TeacherService {
	
	private TeacherDao teacherDao = new TeacherDao();

	public boolean addTeacher(Teacher teacher) {
		return teacherDao.addTeacher(teacher);
	}

	public List<Teacher> getTeachers() {
		return teacherDao.getTeachers();
	}
	
	
	
}
