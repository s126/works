package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String ActionName = arg0.getProxy().getActionName();
		if(ActionName.equals("index")){
			System.out.println("Œ“‘⁄interceptor--index");
		}
		return arg0.invoke();
	}
}
