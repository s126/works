<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师信息列表</title>
</head>
<body>
	<table>
	<tr>
		<td>姓名</td>
		<td>id号</td>
		<td>电话号码</td>
	</tr>
	
	<s:iterator var="t" value="teas">
		<tr>
			<td><s:property value="#t.name"/></td>
			<td><s:property value="#t.tid"/></td>
			<td><s:property value="#t.tel"/></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>