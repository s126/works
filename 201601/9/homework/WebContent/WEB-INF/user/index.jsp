<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<s:form action="login" method="post">
		<s:textfield label="账号" name="name"/>
		<s:password  label="密码" name="pwd"/>
		<s:textfield label="生日" type="date" name="birth"/>
		<s:select name="type" label="身份" list="#{'1':'学生','2':'老师','3':'校长'}"></s:select>
		<s:radio label="性别" list="#{1:'男',2:'女'} " name="sex" />
		<s:textfield name="Email" label="邮箱"/>
		<s:textfield label="手机号" name="phone" />
		<s:submit value="注册" align="center"/>
	</s:form>
</body>
</html>