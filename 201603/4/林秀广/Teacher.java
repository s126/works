package com.s126.bean;

import java.util.HashSet;
import java.util.Set;

public class Teacher {

	private Integer	teacherid;
	
	private String teachername;
	
	private Set<Student> students = new HashSet<Student>();

	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher() {
		super();
	}

	public Teacher(Integer teacherid, String teachername, Set<Student> students) {
		super();
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.students = students;
	}
	
	
}
