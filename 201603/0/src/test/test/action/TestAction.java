package test.action;

public class TestAction {
	
	private String name;

	public String testInterceptor() {
		System.out.println("现在位置： TestAction 的  testInterceptor 方法");
		return "success";
	}

	// 测试，如果没有进行默认拦截器配置的话，那么程序是否会走 defaultStack 里面的拦截器.
	public String testNoDefault() {
		System.out.println(name);
		return "success";
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
