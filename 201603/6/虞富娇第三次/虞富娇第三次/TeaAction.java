package s126.hello.action.copy;

import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.copy.Teacher;
import s126.hello.service.copy.StuService;
import s126.hello.service.copy.TeaService;

public class TeaAction {
	private Teacher tea;
	private List<Teacher> teas = new ArrayList<Teacher>();
	private TeaService teaService = new TeaService();
	
	public String getAllTeas() {
		teas = teaService.getTeas();
		return "AllTeas";
	}
	
	public String addTea() {
		boolean bl = false;
		bl = teaService.addTea(tea);
		return "addTea";
	}

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public TeaService getTeaService() {
		return teaService;
	}

	public void setTeaService(TeaService teaService) {
		this.teaService = teaService;
	}

	public void setTeas(List<Teacher> teas) {
		this.teas = teas;
	}

	public List<Teacher> getTeas() {
		return teas;
	}
	
}
