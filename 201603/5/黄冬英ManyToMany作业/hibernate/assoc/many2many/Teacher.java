package hibernate.assoc.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Teacher {
	
	@Id
	@GeneratedValue
	private int tid;
	
	private String name;
	private String tel;
	
	
	
	@ManyToMany
	@JoinTable // 去定制中间表的详细情况
	private Set<Student> students = new HashSet<Student>();

	
	public Teacher() {
		super();
	}




	public Teacher(int tid, String name, String tel, Set<Student> students) {
		super();
		this.tid = tid;
		this.name = name;
		this.tel = tel;
		this.students = students;
	}





	
	

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




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
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
		return "Teacher [tid=" + tid + ", name=" + name + ", tel=" + tel + "]";
	}
	

}
