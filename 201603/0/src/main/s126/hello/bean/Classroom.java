package s126.hello.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Classroom {
	
	@Id
	@GeneratedValue
	private int crid;
	
	@Column(length=22)
	private String cname;
	private String cdesc;
	
	@OneToMany(mappedBy="classroom")
	private Set<Student> students = new HashSet<Student>();
	
	@OneToMany(mappedBy="classroom")
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public int getCrid() {
		return crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
	
	@Override
	public String toString() {
		return "Classroom [crid=" + crid + ", cname=" + cname + ", cdesc="
				+ cdesc + " ]";
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
}
