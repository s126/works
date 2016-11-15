package com.my.bean2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="dept")
public class Dept {
	@Id
	@GeneratedValue
	private int deptNo;
	private String dname;
	private String loc;
	@OneToMany(mappedBy="deptNo")
	private Set<Emp> emps = new HashSet<Emp>();
	
	
	
	
	@Override
	public String toString() {
		return "Dept [deptno=" + deptNo + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
