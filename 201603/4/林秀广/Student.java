package com.s126.bean;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private Integer studentid;
	
	private String studentname;
	
	private Set<Teacher> teachers = new HashSet<Teacher>();
	

	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public Student(Integer studentid, String studentname, Set<Teacher> teachers) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.teachers = teachers;
	}
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", teachers=" + teachers + "]";
	}

	
}
