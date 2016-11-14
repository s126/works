package com.s126.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue
	private int tid;
	private String name;
	private String kecheng;
	private String sex;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Student> Student = new HashSet<Student>();
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKecheng() {
		return kecheng;
	}
	public void setKecheng(String kecheng) {
		this.kecheng = kecheng;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Set<Student> getStudent() {
		return Student;
	}
	public void setStudent(Set<Student> student) {
		Student = student;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String name, String kecheng, String sex) {
		super();
		this.name = name;
		this.kecheng = kecheng;
		this.sex = sex;
	}
	
	
}
