package test.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import s126.hello.bean.Book;
import s126.hello.bean.Computer;
import s126.hello.bean.Student;

import com.opensymphony.xwork2.ActionContext;


public class OgnlAction implements SessionAware {

	private Student xiaoyueyue;
	private String myname = "shuaige";
	private List<String> haha = new ArrayList<String>();

	private Map<String, Object> global_session = null;

	@SuppressWarnings("unchecked")
	public String testOGNL() {

		xiaoyueyue = new Student("月神", 18);

		// 周强的电脑
		Computer comp = new Computer();
		comp.setType("Thinkpad");
		comp.setPrice(9998);
		// 电脑的名字
		List<String> alias = new ArrayList<String>();
		alias.add("小黑");
		alias.add("Mr.Black");
		alias.add("黑先生");
		comp.setAlias(alias);

		xiaoyueyue.setComp(comp);

		/**
		 * 想在 action 类中获取request,session等对象的方法有如下几种：
		 */

		// 1. 从 ServletActionContext提供的静态方法获取。
		// 比如，ServletActionContext.getRequest() 得到的是一个原生的 HttpServletRequest
		// 对象。得到后我们可以按照以前写 servlet 时候的写法处理这个对象。
		// 所以，如果想得到 Session 对象的话，那么如下代码：
		HttpSession s1 = ServletActionContext.getRequest().getSession();

		s1.setAttribute("flag1", "red");

		// 2. struts 提供了另外一种封装，即把 session,request 等当做 Map 对象来处理，达到简化我们操作的目的。
		// 除了 session，其他的比如 request,parameters,response等对象可以进行同样的操作。
		// session
		Map<String, Object> s2 = ActionContext.getContext().getSession();
		s2.put("flag2", "green");
		// request.
		Map<String, Object> r1 = (Map<String, Object>) ActionContext
				.getContext().get("request");
		r1.put("flag4", "blue");

		// 3. 通过实现 SessionAware 接口，定义全局的 session 对象。
		global_session.put("flag3", "yellow");

		// 4. 通过实现 ServletResponseAware 等接口，可以定义全局的 request 等对象。
		// 代码略，自己尝试一下。

		System.out.println("testOGNL");
		return "success";
	}

	/**
	 * 这个方法中，介绍了 OGNL 表达式的常见用法。 OGNL，有三个主要的元素：表达式，root，context
	 * 表达式是其中的核心，也是我们着重要掌握的。 要多加练习，每段代码都要亲自敲一遍（两遍，三遍……）才能有更切实的收获。 勤能补拙，熟能生巧。
	 * 
	 * @throws OgnlException
	 */
	@SuppressWarnings("unchecked")
	public static void testOgnlExpression() throws OgnlException {

		/* 初始化对象 */
		Computer comp = new Computer(); // 电脑
		comp.setType("MacBook");
		comp.setPrice(8888);
		List<String> alias = new ArrayList<String>();
		alias.add("小黑");
		alias.add("Mr. Black");
		alias.add("黑先生");
		comp.setAlias(alias);

		List<Book> books = new ArrayList<Book>(); // 书籍
		books.add(new Book("aaa", 22));
		books.add(new Book("bbb", 63));
		books.add(new Book("ccc", 93));
		books.add(new Book("ddd", 123));
		books.add(new Book("eee", 223));
		books.add(new Book("fff", 323));

		Student zhouqiang = new Student("周强", 17);
		zhouqiang.setComp(comp);
		zhouqiang.setBooks(books);

		/* 关于 OgnlContext 相关的知识，先看课本的案例 */

		/* 基本使用 */

		// 获取名字
		System.out.println(zhouqiang.getName());
		System.out.println(Ognl.getValue("name", zhouqiang));

		// 获取电脑型号
		System.out.println(zhouqiang.getComp().getType());
		System.out.println(Ognl.getValue("comp.type", zhouqiang));

		// 获取电脑型号的字符串长度
		System.out
				.println("我的电脑名字长度：" + zhouqiang.getComp().getType().length());
		System.out.println("我的电脑名字长度："
				+ Ognl.getValue("comp.type.length()", zhouqiang));

		// 获取电脑的第二个名字
		System.out.println("我的电脑的名字：" + zhouqiang.getComp().getAlias().get(1));
		System.out.println("电脑第二个名字："
				+ Ognl.getValue("comp.alias[1]", zhouqiang));
		System.out.println("电脑名字的数目："
				+ Ognl.getValue("comp.alias.size()", zhouqiang));

		/* 利用 OGNL 表达式创建集合 */
		// 创建 List
		List<String> list1 = (List<String>) Ognl.getValue(
				"{'hello', 'world', 'okay'}", zhouqiang);
		System.out.println("我们创建的 List 是：" + list1);

		// 创建 Map
		Map<String, String> map1 = (Map<String, String>) Ognl.getValue(
				"#{'1':'男', '2':'女'}", zhouqiang);
		System.out.println("我们创建的 Map 是：" + map1);

		/* 在 OGNL 表达式中，如何去调用静态方法。 */
		System.out.println("静态方法调用之 Math.sin(price): "
				+ Ognl.getValue("@java.lang.Math@sin(books[0].price)",
						zhouqiang));

		/* 在 OGNL 表达式中，过滤集合的基本用法。 */

		// 获取拥有的书籍列表（所有）
		// List<Book> books0 = zhouqiang.getBooks();
		List<Book> booksall = (List<Book>) Ognl.getValue("books", zhouqiang);
		System.out.println("所有书籍： " + booksall);

		// 获取价格大于100的所有书籍
		List<Book> books1 = (List<Book>) Ognl.getValue("books.{? price>100}",
				zhouqiang);
		System.out.println("100元以上的书籍：" + books1);

		// 获取价格大于100的第一本书
		List<Book> books2 = (List<Book>) Ognl.getValue("books.{^ price>100}",
				zhouqiang);
		System.out.println("100元以上的第一本：" + books2);

		// 获取价格大于100的最后一本书
		List<Book> books3 = (List<Book>) Ognl.getValue("books.{$ price>100}",
				zhouqiang);
		System.out.println("100元以上的最后一本：" + books3);

		/* 在 OGNL 表达式中，投影集合的基本用法。投影即只显示指定的列 */

		// 显示所有字段
		Ognl.getValue("books", zhouqiang);
		// 生成只含有 name 属性的一个列表
		Object books5 = Ognl.getValue("books.{name}", zhouqiang);
		// Object books5 = Ognl.getValue("books.name", zhouqiang);
		System.out.println("只显示书籍名字的一个投影示例：" + books5);

		// 可以在投影的时候做一些简单的运算
		System.out.println(Ognl.getValue("books.{price + ' 元'}", zhouqiang));
		System.out.println(Ognl.getValue("books.{price + 1000000}", zhouqiang));

		// 投影多个列
		System.out.println("书籍名字和价格的投影示例："
				+ Ognl.getValue("books.{{name,price}}", zhouqiang));
		List<Object> books6 = (List<Object>) Ognl.getValue(
				"books.{#{'name':name, 'price':price}}", zhouqiang);
		// 可以尝试在此对 books6 进行迭代，并判断其中每个值的类型。
		System.out.println("书籍名字和价格的投影示例：" + books6);

		// 另外 % $ @ 等的语法。先自行学习。有问题跟我反馈。
	}

	public static void main(String[] args) throws OgnlException {
		// Ognl表达式
		testOgnlExpression();
	}

	public Student getXiaoyueyue() {
		return xiaoyueyue;
	}

	public void setXiaoyueyue(Student xiaoyueyue) {
		this.xiaoyueyue = xiaoyueyue;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public List<String> getHaha() {
		return haha;
	}

	public void setHaha(List<String> haha) {
		this.haha = haha;
	}

	/**
	 * 如果想实现全局的 session 对象，可以实现 SessionAware 接口 然后，实现接口中的这个方法。 在这里，可以对 session
	 * 进行一些初始化的判断及处理。
	 */

	@Override
	public void setSession(Map<String, Object> session) {
		global_session = session;
	}

}
