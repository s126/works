package hibernate.demo.classroom;

import java.util.List;

public class MainService {
	private MainDao mainDao = new MainDao();
	
	//添加一个学生
	public boolean addStudent(Student stu) {
		
		return mainDao.addStudent(stu);
	}
	//查询全部学生
	public List<Student> QueryStu() {
		return mainDao.QueryStu();
	}

	//添加一个老师
	public boolean addTeacher(Teacher tea) {
		return mainDao.addTeacher(tea);
	}
	//查询全部的老师
	public List<Teacher> QueryTea() {
		return mainDao.QueryTea();
	}
	
	//添加一个班级
	public boolean addClassroom(Classroom cla) {
		return mainDao.addClassRoom(cla);
	}
	//查询全部的班级信息
	public List<Classroom> QueryClass() {
		return mainDao.QueryClass();
	}
	
}
