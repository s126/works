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
	<h1><s:property value="classroom.name" /></h1>
	<div>
	<span>任课老师：</span>
		<s:iterator  var="t" value="classroom.teachers">
		<span>${t.name }</span>&nbsp;&nbsp;
		</s:iterator>
	</div>
	
	<table>
		<caption>学生列表</caption>
		<tr>
			<td>序号</td>
			<td>名字</td>
			<td>性别</td>
		</tr>
		<s:iterator status="i" var="s" value="classroom.students">
		<tr>
			<td>${i.count }</td>
			<td>${s.name }</td>
			<td>${s.sex==1?'女':'男' } </td>
		</tr>
		</s:iterator>
	</table>
	<s:debug />
</body>
</html>