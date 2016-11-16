package hibernate.demo.classroom;

import java.util.ArrayList;
import java.util.List;

public class MainAction {
	private Student student;
	private Teacher teacher;
	private Classroom classroom;
	private MainService mainService = new MainService();
	private List<Classroom> classrooms = new ArrayList<Classroom>();
	private List<Student> students = new ArrayList<Student>();
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	//添加学生
	public String addStu() {
		return "addStu";
	}
	//查询学生
	public String QueryStu() {
		students = mainService.QueryStu();
		return "QueryStu";
	}
	
	//添加老师
	public String addTea() {
		return "addTea";
	}
	//查询老师
	public String QueryTea() {
		teachers = mainService.QueryTea();
		return "QueryTea";
	}
	
	//添加班级
	public String addClass() {
		return "addClass";
	}
	//查询班级
	public String QueryClass() {
		classrooms = mainService.QueryClass();
		return "QueryClass";
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public MainService getMainService() {
		return mainService;
	}
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	public List<Classroom> getClassrooms() {
		return classrooms;
	}
	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
