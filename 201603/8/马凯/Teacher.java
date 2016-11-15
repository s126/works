package s126.hello.bean;

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
	
	private String tername;
	private String tel;
	
	@ManyToMany
	@JoinTable
	private Set<Students> stus = new HashSet<Students>();

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTername() {
		return tername;
	}
	public void setTername(String tername) {
		this.tername = tername;
	}
	public Set<Students> getStus() {
		return stus;
	}
	public void setStus(Set<Students> stus) {
		this.stus = stus;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tername=" + tername + ", tel=" + tel + ", stus=" + stus + "]";
	}
	
	
	
}
