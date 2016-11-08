package com.nf.entity;

public class Users {
	private int uid;
	private String uname;
	private String upwd;
	private Utype utype;
	
	public Users() {
		super();
	}
	
	public Users(int uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}
	public Users(int uid, String uname,  Utype utype) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.utype = utype;
	}
	public Users(int uid, String uname, String upwd, Utype utype) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.utype = utype;
	}

	public Utype getUtype() {
		return utype;
	}
	public void setUtype(Utype utype) {
		this.utype = utype;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", utype=" + utype + "]";
	}
	
	
}
