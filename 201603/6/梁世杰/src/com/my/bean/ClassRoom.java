package com.my.bean;

import java.util.HashSet;
import java.util.Set;

public class ClassRoom {
	private int cid;
	private String name;
	private Set<Student> students = new HashSet<Student>();
	private Set<Teacher> teachers = new HashSet<Teacher>();
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "ClassRoom [cid=" + cid + ", name=" + name + ", students=" + students + ", teachers=" + teachers + "]";
	}
	
}
