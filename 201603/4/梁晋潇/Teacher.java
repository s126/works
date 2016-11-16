package many2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue
	private int tid;
	
	private String tname;
	
	@ManyToMany()
	@JoinTable(name="stu_tea")
	private Set<Student> student = new HashSet<Student>();
	
	
	
	
	
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
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}
	
	

}
