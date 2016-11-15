package com.my.bean;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int tid;
	private String name;
	private int sex;
	private ClassRoom classRoom;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", sex=" + sex +  "]";
	}
	
	
}
