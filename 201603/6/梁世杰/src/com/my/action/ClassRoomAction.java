package com.my.action;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.my.bean.ClassRoom;
import com.my.bean.Student;
import com.my.service.ClassRoomService;

public class ClassRoomAction {
	private List<ClassRoom> classRooms;
	private ClassRoom classroom;
	private Student student;
	
	private Map<Integer,String> calssName;
	private int cid;
	public String list() {
		classRooms = new ClassRoomService().getAll();
		return "list";
	}

	public String details(){
		classRooms = new ClassRoomService().getSome(cid);
		classroom = classRooms.get(0);
		return "details";
	}
	
	public String addStudentPager(){
		calssName = new ClassRoomService().getClassName();
		return "addStudentPager";
	}
	public String addStudent(){
		boolean  bl = new ClassRoomService().addStudent(student, classroom.getCid());
		if(bl)
			return "list";
		else
			return "addStudentPager";
	}
	
	
	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public ClassRoom getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}
	@Test
	public void test(){
		classRooms = new ClassRoomService().getSome(6);
		classroom = classRooms.get(0);
		System.out.println(classroom);
		
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public Map<Integer, String> getCalssName() {
		return calssName;
	}

	public void setCalssName(Map<Integer, String> calssName) {
		this.calssName = calssName;
	}
	
	
	
	
	
	
}
