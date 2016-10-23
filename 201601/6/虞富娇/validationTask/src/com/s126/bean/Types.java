package com.s126.bean;
/*create table vip.types(
		   tid number primary key,
		   tname varchar2(30)
		);*/
public class Types {
	private int tid;
	private String tname;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Types(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public Types() {
		super();
	}
	
}
