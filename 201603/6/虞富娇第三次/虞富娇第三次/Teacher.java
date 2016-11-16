package s126.hello.bean.copy;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {
	private String name;
	@Id
	@GeneratedValue
	private Integer tid;
	private long tel;
	
	@ManyToMany
	private Set<Student> students = new HashSet<Student>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}
	

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", tid=" + tid + ", tel=" + tel + "]";
	}
	
	
	
	
	
}
