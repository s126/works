package s126.hello.action.copy;

import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.copy.Student;
import s126.hello.service.copy.StuService;

public class StuAction {
	private Student stu;
	private List<Student> stus = new ArrayList<Student>();
	private StuService stuService = new StuService();
	
	public String getAllStus() {
		stus = stuService.getStus();
		return "AllStus";
	}
	
	public String addStu() {
		boolean bl = false;
		bl = stuService.addStu(stu);
		return "addStu";
	}
	
	public String errorPage() {
		return "error";
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public StuService getStuService() {
		return stuService;
	}

	public void setStuService(StuService stuService) {
		this.stuService = stuService;
	}

	public void setStus(List<Student> stus) {
		this.stus = stus;
	}

	public List<Student> getStus() {
		return stus;
	}
	
}
