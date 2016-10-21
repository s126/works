package com.s126.demo.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AI extends AbstractInterceptor {

	
	
	/**
	 * struts 中类型的自动转换，自动赋值，验证等功能都是通过内置的一些拦截器实现的。
	 * 这是自定义的一个拦截器。
	 * 自定义拦截器需要实现 Interceptor 接口，也可以直接继承 AbstractInterceptor类。
	 */
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("现在进入 AI");
		
		String result = invocation.invoke();
		
		System.out.println("现在离开 AI");
		
		return result;
	}

}
