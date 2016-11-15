package com.my.action;

import java.util.*;

import com.my.Dao.HibernateDao;
import com.my.entity.ClassRoom;
import com.my.entity.student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class classRoomAction extends ActionSupport{

	private List<student> cls = new ArrayList<student>();
	private student stu;
	private ClassRoom clss;
	
	public String index () {
		String sql = "From student";
		cls = new HibernateDao().findAll(sql);
		return "index";
	}

	public String addStudent () {
		Map<Integer,String> classnames = new HashMap<Integer,String>();
		List<ClassRoom> room = new HibernateDao().findAll("from ClassRoom");
		for (ClassRoom r : room) {
			classnames.put(r.getClass_id(), r.getClass_name());
		}
		ActionContext.getContext().getSession().put("cls_name",classnames);
		return "addIndex";
	}

	public String addStudenting () {
		clss = (ClassRoom) new HibernateDao().getById(ClassRoom.class, clss.getClass_id());
		clss.getStudents().add(stu);
		stu.setStu_cls(clss);
		boolean bl = new HibernateDao().Save(clss);
		if(bl)
			return index();
		else
			return addStudent();
	}
	
	public List<student> getCls() {
		return cls;
	}


	public void setCls(List<student> cls) {
		this.cls = cls;
	}

	public student getStu() {
		return stu;
	}

	public void setStu(student stu) {
		this.stu = stu;
	}

	public ClassRoom getClss() {
		return clss;
	}

	public void setClss(ClassRoom clss) {
		this.clss = clss;
	}

	
}
