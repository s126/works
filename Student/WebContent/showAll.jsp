<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/Student/NewFile.jsp">添加学员</a>
	<table border=1 >
		<tr>
			<td>stuid</td>
			<td>stunaem</td>
			<td>stusex</td>
			<td>dormitoryinDate</td>
			<td>dormitoryoutDate</td>
			<td>dormitoryId</td>
		</tr>
		<c:forEach items="${requestScope.ls }" var="s">
			<tr>
			<td>${s.stuid }</td>
				<td>${s.stuname }</td>
				<td>${s.stusex }</td>
				<td>${s.dormitoryinDate }</td>
				<td>${s.dormitoryoutDate }</td>
				<td>${s.dormitoryId }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>