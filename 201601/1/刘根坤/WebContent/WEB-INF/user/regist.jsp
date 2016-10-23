<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>服务员注册</title>
</head>
<body>
<div>
	<s:form action="registSubmit">
		<s:textfield  name="u_num" label="编号" />
		<s:textfield  name="u_name" label="名字" />
		<s:textfield  name="u_email" label="邮箱" />
		<s:textfield  name="u_phone" label="电话"/>
		<s:radio name="u_sex" list="{'男','女'}" label="性别"></s:radio>
		<s:password  name="u_password" label="密码" />
		<s:password  name="u_repassword" label="确认" />
		<s:submit value="注册" align="center"/>
	</s:form>
</div>
</body>
</html>