package com.my.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClassRoom {

	@Id
	@GeneratedValue
	private Integer class_id;
	private String class_name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="t_cls",fetch=FetchType.EAGER)
	private Set<Teacher> teachers = new HashSet<Teacher>();
	@OneToMany(mappedBy="stu_cls",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<student> students = new HashSet<student>();
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Set<student> getStudents() {
		return students;
	}
	public void setStudents(Set<student> students) {
		this.students = students;
	}
	
}
