package s126.hello.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import s126.hello.bean.Classroom;
import s126.hello.service.ClassroomService;

public class ClassroomAction extends ActionSupport {

	private Classroom classroom;
	private ClassroomService classroomService = new ClassroomService();
	private List<Classroom> classrooms = new ArrayList<Classroom>();
	
	
	public String addIndex() {
		return "addIndex";
	}
	
	
	public String addClassroom() {
		return classroomService.addClassroom(classroom) ? getClassroomList() :"error";
	}


	public String getClassroomList() {
		
		classrooms = classroomService.getClassrooms();
		
		return "classlist";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Classroom getClassroom() {
		return classroom;
	}


	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
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
	
}
