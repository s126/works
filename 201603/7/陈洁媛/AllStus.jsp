<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>
	<table>
	<tr>
		<td>姓名</td>
		<td>id号</td>
		<td>生日</td>
	</tr>
	
	<s:iterator var="s" value="students">
		<tr>
			<td><s:property value="#s.name"/></td>
			<td><s:property value="#s.sid"/></td>
			<td><s:property value="#s.birth"/></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>