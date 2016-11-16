package s126.hello.action;

import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.Emp;
import s126.hello.service.EmpService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class EmpAction extends ActionSupport {
	private Emp emp;
	private String msg;
	private String input;
	private List<Emp> emps = new ArrayList<Emp>();
	private int min;
	private int max;

	private EmpService empService = new EmpService();

	/* 显示所有员工 */
	public String listAll() {
		emps = empService.getAll();
		return "list";
	}

	/* 模糊查询 */
	public String filter() {
		emps = empService.getSome(input);
		return "list";
	}

	/* 按照工资范围查询 */
	@InputConfig(resultName = "list")
	public String filterSal() {
		emps = empService.getBySalRange(min, max);
		return "list";
	}

	/* 删除员工 */
	public String delete() {
		return empService.delete(emp.getEmpno()) ? "delete" : "error";
	}

	/* 更新员工信息 */
	public String update() {
		System.out.println("更新员工");
		return "update";
	}

	/* 增加员工首页 */
	public String addIndex() {
		System.out.println("增加员工");
		ActionContext.getContext().getSession().put("jobs", empService.getJobs());
		return "addIndex";
	}

	/* 增加员工 */
	public String addSubmit() throws Exception {
		boolean bl = false;
		bl = empService.add(emp);

		if (bl) {
			msg = "添加成功";
			return listAll();
		} else {
			msg = "添加失败";
			return addIndex();
		}

	}

	/* 显示页面搜索功能 */
	public String search() {
		emps = empService.getSome(input);
		return SUCCESS;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
