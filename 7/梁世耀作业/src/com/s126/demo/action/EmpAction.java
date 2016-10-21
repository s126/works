package com.s126.demo.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.s126.demo.bean.Emp;
import com.s126.demo.dao.EmpDao;

public class EmpAction extends ActionSupport {
	
	private String ename = "hello";
	private List<Emp> emps = new ArrayList<Emp>();
	
	EmpDao empDao = new EmpDao();
	
	/* 显示所有员工 */
	public String listAll () {
		emps = empDao.getAll();
		return "listAll";
	}
	
	/* 删除员工 */
	public String delete() {
		boolean bl=new EmpDao().delete(ename);
		if(bl){
			return "delete";
		}
		return "error";
		
	}
	
	/* 增加员工 */
	public String add(){
		System.out.println("������");
		return "add";
	}
	
	/* 更新员工信息 */
	public String update(){
		System.out.println("�������");
		return "update";
	}
	


	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

}
