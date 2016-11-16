package hibernate.demo.homeword;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(generator="tid")
	@GenericGenerator(name="tid",strategy="sequence",parameters={@Parameter (name="sequence",value="sequence_tid")})
	private int tid;
	private String tname;
	
	@OneToMany(mappedBy="teacher")
	private Set<Student> students = new HashSet<Student>();
	
	
	
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
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", students=" + students + "]";
	}
	
	
}
