package hibernate.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author D.O
 * @version 创建时间：2016年11月11日 下午2:02:28
 * 简单说明
 */
@Entity
public class Teacher {
	@Id
	@GeneratedValue
	private int tid;
	private String name;
	
	@ManyToMany()
	private Set<Student> students = new HashSet<Student>();

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher() {
		super();
	}

	public Teacher(String name, Set<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + "]";
	}





	
	
}
