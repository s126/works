package com.s126.demo.bean;

public class Emp {

	private String name;
	private int sal;
	private String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", sal=" + sal + ", job=" + job + "]";
	}

}
