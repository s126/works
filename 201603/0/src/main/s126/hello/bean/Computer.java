package s126.hello.bean;

import java.util.ArrayList;
import java.util.List;


public class Computer {
	
	// 型号
	private String type;
	// 价格
	private int price;
	// 电脑的名字
	private List<String> alias = new ArrayList<String>();
	
	public List<String> getAlias() {
		return alias;
	}
	public void setAlias(List<String> alias) {
		this.alias = alias;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
