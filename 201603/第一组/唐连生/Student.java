package many2Many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Administrator
 * @version  
 */

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int ssid;
	
	private String name;
	
	@ManyToMany(mappedBy="student")

	private Set<Teacher> teacher = new HashSet<Teacher>();
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	
	
}
