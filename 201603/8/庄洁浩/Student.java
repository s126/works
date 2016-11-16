package hibernate.demo.homeword;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Student {
	@Id
	@GeneratedValue(generator="sid")//指定序列
	@GenericGenerator(name="sid", strategy="sequence", parameters = {@Parameter(name = "sequence", value = "sequence_sid")})
	private int sid;
	
	@Column
	private String sname;
	
	
	@ManyToOne
	//外键列名
	@JoinColumn(name="teacher")
	private Teacher teacher;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", teacher=" + teacher + "]";
	}
	
	
}
