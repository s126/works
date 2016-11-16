package test.main;


import s126.hello.bean.Book;

/* 实例化对象的方式 */
public class InstanceDemo {
	
	public static void main(String[] args) throws Exception {
		
		// 第一种， new 方法
		Book book1 = new Book();
		book1.setName("oracle");
		book1.setPrice(1000);
		
		// 第二种，带参的 new 方法
		Book book2 = new Book("Struts", 2000);
		
		// 第三种，newInstance
		Book book3 = (Book) Class.forName("s126.hello.bean.Book").newInstance();
		Book book4 = Book.class.newInstance();
		book4.setName("Hibernate");
		book4.setPrice(1234);
		
		// 第四种，带参的 newInstance
		Book book5 = Book.class.getDeclaredConstructor(String.class, int.class).newInstance("Spring", 4111);
		
		System.out.printf("%s\n%s\n%s\n%s\n%s\n", book1, book2, book3, book4, book5);
		System.out.println(System.out);
	}
}
