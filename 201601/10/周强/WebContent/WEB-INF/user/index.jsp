<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	
	<s:form action="login" method="post">
		<s:textfield label="账号" name="name" />
		<s:password label="密码" name="pwd" />
		<s:password label="确认密码" name="pwd1" />
		<s:radio label="性别" list="#{1:'男',2:'女'} " name="sex" />
		<s:textfield label="生日" type="date" name="birthday" />
		<s:textfield label="邮箱"  name="email" />
		<s:textfield label="手机号" name="phone" />
		<s:select label="类型" name="type" list="#{1:'学生', 2:'老师', 3:'校长'}"></s:select>
		<s:submit value="注册" />
	</s:form>
</body>
</html>