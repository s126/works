package com.my.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private Integer tid;
	private String t_name;
	private int t_sex;
	private Date t_birth;
	@ManyToOne
	@JoinColumn(name="classroom")
	private ClassRoom t_cls;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public int getT_sex() {
		return t_sex;
	}
	public void setT_sex(int t_sex) {
		this.t_sex = t_sex;
	}
	public Date getT_birth() {
		return t_birth;
	}
	public void setT_birth(Date t_birth) {
		this.t_birth = t_birth;
	}
	public ClassRoom getT_cls() {
		return t_cls;
	}
	public void setT_cls(ClassRoom t_cls) {
		this.t_cls = t_cls;
	}
	
}
