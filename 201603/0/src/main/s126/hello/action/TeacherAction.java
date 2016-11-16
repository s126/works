package s126.hello.action;

import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.Classroom;
import s126.hello.bean.Teacher;
import s126.hello.service.ClassroomService;
import s126.hello.service.TeacherService;

public class TeacherAction {
	
	private TeacherService teacherService = new TeacherService();
	private ClassroomService classroomService = new ClassroomService();
	private Teacher teacher;
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private List<Classroom> classrooms = new ArrayList<Classroom>();
	private int cid;
	
	public String addIndex() {
		classrooms = classroomService.getClassrooms();
		
		return "addIndex";
	}
	
	public String addTeacher() {
		teacher.setClassroom(classroomService.getClassroom(cid));
		return teacherService.addTeacher(teacher) ? teachersList():"error";
	}
	
	public String teachersList() {
		teachers = teacherService.getTeachers();
		
		return "teacherlist";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
	
	
	
}
