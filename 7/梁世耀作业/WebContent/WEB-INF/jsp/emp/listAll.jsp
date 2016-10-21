<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示所有员工信息</title>
</head>
<body>


<s:debug></s:debug>


<table>
	<tr>
		<td>姓名</td>
		<td>工作</td>
		<td>工资</td>
	</tr>
	
	<s:iterator var="j" value="emps.{? #this.sal > 1000 }">
		<tr>
			<td>${name}</td>
			<td><s:property value="job"/></td>
			<td><s:property value="#j.sal"/></td>
			<td>
				<s:if test="#session.account.acctype == 2 || #session.account.acctype == 3">
					<a href="delete.html?ename=${name}">删除</a>
				</s:if>
				
			</td>	
		</tr>
	</s:iterator>
	
	
</table>

</body>
</html>