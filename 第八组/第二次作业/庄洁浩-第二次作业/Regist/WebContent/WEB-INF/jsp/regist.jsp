<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>

</head>
<body>
	<s:form action="registerSubmit" method="post">
		<s:textfield label="账号" name="name" />
		<s:radio label="性别" name ="sex" list="#{0:'男',1:'女'}"/>
		<s:textfield label="生日" type="date" name="birthday" />
		<s:textfield label="电话号码" name="photonum" />
		<s:textfield label="邮件" name="email" /> 
		<s:textfield label="密码" name="password" />
		<s:textfield label="确认密码" name="passwords" />
		<s:select label="类型" name="acctype" list="#{1:'学生', 2:'老师', 3:'校长'}" />
		<s:submit value="注册" />
	</s:form>
	<s:debug></s:debug>
</body>
</html>