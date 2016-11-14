package s126.hello.action;

import s126.hello.bean.Students;
import s126.hello.dao.StudentDao;

public class StudentAction {
	private Students students;
	private String msg;

	private StudentDao studentDao = new StudentDao();

	public String getStudents() {
		students = (Students) studentDao.getStudents();
		return "getStudents";
	}

	public String addStudents() {
		boolean bl = false;
		bl = studentDao.addStudent(students);

		if (bl) {
			msg = "添加成功";
			return getStudents();
		} else {
			msg = "添加失败";
			return "fail";
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	

}
