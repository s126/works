package s126.hello.action;

import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.Classroom;
import s126.hello.bean.Student;
import s126.hello.service.ClassroomService;
import s126.hello.service.StudentService;

public class StudentAction {
	
	
	private Student student;
	private StudentService studentService = new StudentService();
	
	private ClassroomService classroomService = new ClassroomService();
	private List<Classroom> classrooms = new ArrayList<Classroom>();
	private List<Student> studentLists = new ArrayList<Student>();
	private int crid;
	/**
	 * 到添加页面
	 */
	public String addIndex() {
		classrooms = classroomService.getClassrooms();
		
		return "addIndex";
	}

	/**
	 * 添加一个学生
	 */
	public String addStudent() {
		return studentService.addStudent(student) ? studentList():"error";
	}
	
	/**
	 * 获取所有老师
	 */
	public String studentList() {
		studentLists = studentService.getStudents();
		
		return "studentlist";
	}
	
	/**
	 * 根据 教室id  获取所有的学生
	 */
	public String stusbycrid () {
		studentLists = studentService.getStudentsBycrid(crid);
		return "studentlist";
	}
	
	public String lookTeacher() {
		return "lookTeacher";
	}
	
	
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public ClassroomService getClassroomService() {
		return classroomService;
	}

	public void setClassroomService(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public List<Student> getStudentLists() {
		return studentLists;
	}

	public void setStudentLists(List<Student> studentLists) {
		this.studentLists = studentLists;
	}

	public int getCrid() {
		return crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}
	
	
	
}
