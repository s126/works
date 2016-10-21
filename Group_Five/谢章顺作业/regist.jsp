<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <s:form action="Regist" > <!-- FORM表单 -->  
            <s:label value="注册系统"></s:label>
            <s:textfield name="users" label="账号"></s:textfield>  
            <s:password name="password" label="密码"></s:password>  
            <s:password name="pwd" label="确认密码"></s:password>
            <s:textfield name="email" label="邮箱"></s:textfield>  
            <s:textfield name="phone" label="手机"></s:textfield>  
            
           	<s:select name="sex"  label="性别" list="#{1:'男',2:'女'}"></s:select> 
           	
            <s:submit value="注册"></s:submit>  
        </s:form> 
</body>
</html>