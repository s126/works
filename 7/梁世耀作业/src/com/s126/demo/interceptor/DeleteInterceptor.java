package com.s126.demo.interceptor;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.s126.demo.bean.Account;

public class DeleteInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		Account acc = (Account) ActionContext.getContext().getSession().get("account");
		if (acc!= null && ls.contains(acc.getAcctype())){
			return invocation.invoke();
		}else{
			return "ierror";
		}
		
	}

}
