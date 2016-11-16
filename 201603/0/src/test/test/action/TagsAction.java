package test.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import s126.hello.bean.Book;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 用来显示标签使用的一个测试 Action
 */
public class TagsAction extends ActionSupport implements Comparator<Book>{
	
	private List<Book> booklist = new ArrayList<Book>();
	
	public String tags() {
		
		booklist.add(new Book("struts", 22));
		booklist.add(new Book("oracle", 32));
		booklist.add(new Book("javascript", 88));
		booklist.add(new Book("怎么与女主播相处", 38));
		booklist.add(new Book("与男主播的日子", 18));
		booklist.add(new Book("刷礼物指南", 91));
		booklist.add(new Book("土狗烹饪", 58));
		
		return SUCCESS;
	}
	
	
	
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	
	@Override
	public int compare(Book o1, Book o2) {
		return o2.getPrice() - o1.getPrice();
	}
}
