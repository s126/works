package com.s126.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="stus")
public class Student {
	@Id
	@GeneratedValue
	private int sid;
	private String name;
	private String sex;
	private int Ages;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Teacher> teacher = new HashSet<Teacher>();

	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAges() {
		return Ages;
	}

	public void setAges(int ages) {
		Ages = ages;
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}

	public Student(String name, String sex, int ages) {
		super();
		this.name = name;
		this.sex = sex;
		Ages = ages;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
