package s126.hello.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Teacher { // 老师

	@Id
	@GeneratedValue
	private Integer tid;
	private String name;
	private Date birth;
	
	private String banji;//班级

	@OneToMany(mappedBy = "teacher")
	private Set<Students> students = new HashSet<Students>();

	@Transient
	private int age;

	public Teacher() {
		super();
	}


	


	public Teacher(Integer tid, String name, Date birth, String banji, Set<Students> students, int age) {
		super();
		this.tid = tid;
		this.name = name;
		this.birth = birth;
		this.banji = banji;
		this.students = students;
		this.age = age;
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


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getBanji() {
		return banji;
	}


	public void setBanji(String banji) {
		this.banji = banji;
	}


	public Set<Students> getStudents() {
		return students;
	}


	public void setStudents(Set<Students> students) {
		this.students = students;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", birth=" + birth + ", banji=" + banji + ", students="
				+ students + ", age=" + age + "]";
	}



	

}
