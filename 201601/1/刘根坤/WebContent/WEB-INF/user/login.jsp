<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
</head>
<body>

<header>请输入您的用户名密码进行登陆</header>

<div id="main">
	<s:debug></s:debug>
	<s:form action="loginSubmit.html">
		<s:textfield  name="u_num" label="编号" />
		<s:textfield  name="u_password" label="密码" />
		<s:submit value="登录" />
	</s:form>
	
	<div>首次登陆前往<a href="register.html">注册</a></div>
</div>

<footer>欢迎光临。</footer>

</body>
</html>