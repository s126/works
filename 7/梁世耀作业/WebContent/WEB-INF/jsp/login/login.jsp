<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
</head>
<body>

<header>请输入您的用户名密码进行登陆</header>

<div class="centerblock">
	
	<s:form action="loginSubmit">
		<s:textfield name="name" label="账号"></s:textfield>
		<s:textfield name="pwd" label="密码"></s:textfield>
		<s:submit value="登录"></s:submit>
	</s:form>
	
</div>

<div>首次登陆前往<a href="register.html">注册</a></div>



<s:debug></s:debug>

</body>
</html>