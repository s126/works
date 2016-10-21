package com.s126.demo.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.s126.demo.bean.Account;

public class ListAllInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得用户登录相关的信息
		Account acc = (Account) ActionContext.getContext().getSession().get("account");
		if (!invocation.getProxy().getNamespace().equalsIgnoreCase("/emp") || acc == null) {
			return "error";
		}else {
			return invocation.invoke();
		}
		
	}

}
