package s126.hello.bean;

import java.util.Date;

public class Item {
	private int id;
	private String name;
	private float price;
	private Date cdate;
	private int status = -1;
	
	public Item () {}
	
	public Item(int id, String name, float price, Date cdate, int status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cdate = cdate;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "(" + name + ", " + price + ", " + cdate + ", " + status + ")";
	}

}
