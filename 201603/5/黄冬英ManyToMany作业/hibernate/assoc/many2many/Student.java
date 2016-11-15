package hibernate.assoc.many2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Student {

	@Id
	@GeneratedValue
	private int sid;
	private String name;
	private long qq;
	
	@ManyToMany(mappedBy="students")
	private Set<Teacher> teachers = new HashSet<Teacher>();
	

	
	public Student() {
		super();
	}

	public Student(int sid, String name, long qq, Set<Teacher> teachers) {
		super();
		this.sid = sid;
		this.name = name;
		this.qq = qq;
		this.teachers = teachers;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQq() {
		return qq;
	}

	public void setQq(long qq) {
		this.qq = qq;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", qq=" + qq + "]";
	}

	
	
}
