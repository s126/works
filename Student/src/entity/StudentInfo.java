package entity;

import java.sql.Date;

public class StudentInfo {
	String stuid;// VARCHAR2(12) NOT NULL ENABLE, 
	String stuname;// VARCHAR2(16) NOT NULL ENABLE, 
	String stusex; //VARCHAR2(3) NOT NULL ENABLE, 
	Date dormitoryinDate;//DORMITORYINDATE;// DATE, 
	Date dormitoryoutDate;// DATE, 
	int dormitoryId;// NUMBER(*,0),
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public Date getDormitoryinDate() {
		return dormitoryinDate;
	}
	public void setDormitoryinDate(Date dormitoryinDate) {
		this.dormitoryinDate = dormitoryinDate;
	}
	public Date getDormitoryoutDate() {
		return dormitoryoutDate;
	}
	public void setDormitoryoutDate(Date dormitoryoutDate) {
		this.dormitoryoutDate = dormitoryoutDate;
	}
	public int getDormitoryId() {
		return dormitoryId;
	}
	public void setDormitoryId(int dormitoryId) {
		this.dormitoryId = dormitoryId;
	}
	public StudentInfo(String stuid, String stuname, String stusex,
			Date dormitoryinDate, Date dormitoryoutDate, int dormitoryId) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stusex = stusex;
		this.dormitoryinDate = dormitoryinDate;
		this.dormitoryoutDate = dormitoryoutDate;
		this.dormitoryId = dormitoryId;
	}
	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
