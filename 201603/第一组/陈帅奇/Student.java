package hibernate.student;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue
	private Integer stid;
	private String stno;
	private String stname;
	private String classno;
	
	@ManyToMany(mappedBy="students")
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStno() {
		return stno;
	}
	public void setStno(String stno) {
		this.stno = stno;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	@Override
	public String toString() {
		return "Student [stid=" + stid + ", stno=" + stno + ", stname=" + stname + ", classno="
				+ classno + "]";
	}
	
	
}
