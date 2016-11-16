package hibernate.helloworld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_book")
public class Book {
	
	@Id
	@GeneratedValue
	private Integer bookno;
	
	@Column(nullable=false, length=22)
	private String name;
	private Integer price;
	
	public Book() {
		super();
	}
	
	public Book(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Integer getBookno() {
		return bookno;
	}
	public void setBookno(Integer bookno) {
		this.bookno = bookno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [bookno=" + bookno + ", name=" + name + ", price=" + price
				+ "]";
	}
	
	

}
