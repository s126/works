package hello.s126.bean;
import hello.s126.until.HbUntil;
//@Entity
public class Emp extends HbUntil{
	//@Id
	//@GeneratedValue
	private int empno;     //部门编号
	private String ename;  //部门编号
	private int sal;       //工资
	private String job;    //工作名
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal
				+ ", job=" + job + "]";
	} 
}
