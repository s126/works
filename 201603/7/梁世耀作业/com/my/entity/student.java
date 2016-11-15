package com.my.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class student {

	@Id
	@GeneratedValue
	private Integer stuid;
	private String stuname;
	private Date stu_birth;
	@ManyToOne
	@JoinColumn(name="classroom")
	private ClassRoom stu_cls;
	public ClassRoom getStu_cls() {
		return stu_cls;
	}
	public void setStu_cls(ClassRoom stu_cls) {
		this.stu_cls = stu_cls;
	}
	public Integer getStuid() {
		return stuid;
	}
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public Date getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(Date stu_birth) {
		this.stu_birth = stu_birth;
	}
	@Override
	public String toString() {
		return "student [stuid=" + stuid + ", stuname=" + stuname + ", stu_birth=" + stu_birth 
				+ "]";
	}
	
}
