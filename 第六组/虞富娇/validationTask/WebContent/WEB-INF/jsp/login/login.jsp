<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆</title>
</head>
<body>

<header>请输入您的用户名密码进行登陆</header>

<div id="main">
	<form action="loginSubmit.html" method="get">
		<div>
			<label>账号</label>
			<input type="text" name="name">
	    </div>
		<div>
			<label>密码</label>
			<input type="password" name="pwd">
		</div>
		<input type="submit" value="登陆">		
	</form>
	
	<div>首次登陆前往<a href="register.html">注册</a></div>
</div>

<footer>欢迎光临。</footer>

</body>
</html>