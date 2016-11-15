<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="addStudent">
		<s:textfield label="学生名称" name="student.name" />
		<s:radio list="#{'0':'女','1':'男'}" name="student.sex" label="性别" />
		<s:select list="calssName" name="classroom.cid" label="所属班级"></s:select>
		<s:submit value="提交" />
	</s:form>
</body>
</html>