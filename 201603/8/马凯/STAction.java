package s126.hello.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import s126.hello.bean.Teacher;
import s126.hello.dao.STDao;

public class STAction extends ActionSupport{
	private String student;
	private String teacher;
	private List<Teacher> list = new ArrayList<Teacher>();
	STDao sts = new STDao();
	
	public String getAllstu(){
		list = STService.getAll();
		if(list==null){
			return "false";
		}
		return "getAllstu";
	}
	
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
}
