package com.nf.entity;

import java.util.HashSet;
import java.util.Set;

public class Utype {
	private int tid;
	private String tname;
	private Set<Users> users = new HashSet<Users>(0);
	public int getTid() {
		return tid;
	}
	public String getTname() {
		return tname;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	public Utype(int tid, String tname, Set<Users> users) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.users = users;
	}
	public Utype(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public Utype() {
		super();
	}
	@Override
	public String toString() {
		return "Utype [tid=" + tid + ", tname=" + tname + ", users=" + users + "]";
	}
	

	
}
