package s126.hello.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;

public class Students {
	private int sid;
	private String stus;
	private String QQ;
	
	@ManyToMany(mappedBy="stus")
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStus() {
		return stus;
	}

	public void setStus(String stus) {
		this.stus = stus;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public Students() {
		super();
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", stus=" + stus + ", QQ=" + QQ + ", teachers=" + teachers + "]";
	}
	
	
	
	

}
