package hibernate.assoc.many2many_me;

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
public class Student {
	private String name;
	private Integer sid;
	private long tel;
	
	
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	@ManyToMany(mappedBy="students")
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sid=" + sid + ", tel=" + tel + "]";
	}
	
	
	
}
