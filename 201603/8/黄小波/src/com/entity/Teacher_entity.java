package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher_entity { //��ʦ��
	private int  tid; //��ʦ���
	private String  tname; //��ʦ����
	private String tcourse;//��Ŀ
	
	
	private Set<Student_entity> students = new HashSet<Student_entity>();
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTcourse() {
		return tcourse;
	}
	public void setTcourse(String tcourse) {
		this.tcourse = tcourse;
	}
	public Teacher_entity() {  //�޲ι�����
		super();
	}
	public Set<Student_entity> getStudents() {
		return students;
	}
	public void setStudents(Set<Student_entity> students) {
		this.students = students;
	}
	public Teacher_entity(String tname, String tcourse) {
		super();
		this.tname = tname;
		this.tcourse = tcourse;
	}
	
	
}
