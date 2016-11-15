<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="addStudentPager">添加学生</a>
	<table>
		<tr>
			<td>序号</td>
			<td>班级名称</td>
			<td>学生人数</td>
			<td>查看详情</td>
		</tr>
		<s:iterator status="i" var="c" value="classRooms">
			<tr>
				<td> ${i.count }</td>
				<td>${c.name }</td>
				<td>${c.students.size() }</td>
				<td><a href="details?cid=${c.cid }">详情</a></td>
			</tr>
		</s:iterator>
	</table>
	<s:debug />
</body>
</html>