<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
	<s:form action="addStudenting" method="post">
		<s:textfield label="姓名" name="stu.stuname"></s:textfield>
		<s:textfield label="生日" name="stu.stu_birth"></s:textfield>
		<s:select label="班级" list="#session.cls_name" name="clss.class_id"></s:select>
		<s:submit value="添加"></s:submit>
	</s:form>
</body>
</html>