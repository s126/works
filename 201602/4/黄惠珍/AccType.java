package s126.hello.bean;

public class AccType {
	private int tid;
	private String tname;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public AccType(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "AccType [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
}
