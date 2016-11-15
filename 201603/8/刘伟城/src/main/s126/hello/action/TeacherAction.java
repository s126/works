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
	private int crid;
	
	public String addIndex() {
		classrooms = classroomService.getClassrooms();
		
		return "addIndex";
	}
	
	public String addTeacher() {
		return teacherService.addTeacher(teacher) ? teachersList():"error";
	}
	
	public String teachersList() {
		teachers = teacherService.getTeachers();
		
		return "teacherlist";
	}
	
	
	/**
	 * 根据 教室id  获取所有的老师
	 */
	public String teasbycrid () {
		teachers = teacherService.getTeachersBycrid(crid);
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

	public int getCrid() {
		return crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}
	
	
	
	
}
