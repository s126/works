package entity;

public class Student {
	private String stuid;
	private String stuname;
	private String stusex;
	private String DORMITORYINDATE;
	private String DORMITORYOUTDATE;
	private int DORMITORYID;
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
	public String getDORMITORYINDATE() {
		return DORMITORYINDATE;
	}
	public void setDORMITORYINDATE(String dORMITORYINDATE) {
		DORMITORYINDATE = dORMITORYINDATE;
	}
	public String getDORMITORYOUTDATE() {
		return DORMITORYOUTDATE;
	}
	public void setDORMITORYOUTDATE(String dORMITORYOUTDATE) {
		DORMITORYOUTDATE = dORMITORYOUTDATE;
	}
	public int getDORMITORYID() {
		return DORMITORYID;
	}
	public void setDORMITORYID(int dORMITORYID) {
		DORMITORYID = dORMITORYID;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", stusex=" + stusex + ", DORMITORYINDATE="
				+ DORMITORYINDATE + ", DORMITORYOUTDATE=" + DORMITORYOUTDATE + ", DORMITORYID=" + DORMITORYID + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
