package hibernate.demo.classroom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int stuid;
	
	@Column(nullable=false)
	private String name;
	private int sex;
	private Date birth;
	
	@ManyToOne
	@JoinColumn(name="classroom")
	private Classroom classroom;

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", sex=" + sex
				+ ", birth=" + birth + ", classroom=" + classroom + "]";
	}
	

}
