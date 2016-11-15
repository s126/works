package hibernate.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author D.O
 * @version 创建时间：2016年11月11日 下午2:02:36
 * 简单说明
 */
@Entity
public class Student {
	@Id
	@GeneratedValue
	private int sid;
	private String name;
	
	@ManyToMany
	
	private Set<Teacher> teachers = new HashSet<Teacher>();

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

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Student() {
		super();
	}

	public Student(String name, Set<Teacher> teachers) {
		super();
		this.name = name;
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + "]";
	}





	
	
	
}
