package test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BI extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("现在进入 BI");
		
		String result = invocation.invoke();
		
		System.out.println("现在离开 BI");
		
		return result;
	}
}
