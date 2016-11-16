<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>员工增加</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
<style type="text/css">
	.table{
		margin: 50px auto;
		width: 300px;
	}
	.table tr td{
		border: none !important;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
	<h1>添加员工</h1><hr>
	<s:form action="addSubmit" method="post" class="form-horizontal" theme="simple">
		<s:token />
		<table class="table">
			<tr>
				<td><label class="control-label">姓名：</label></td>
				<td><s:textfield label="姓名" name="emp.ename" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">工资：</label></td>
				<td><s:textfield label="工资" name="emp.sal" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">职位：</label></td>
				<td><s:select label="职位" list="#session.jobs" name="emp.job" class="form-control"/></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="添加" class="btn btn-success btn-block"/></td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>
<%-- 
<s:form action="addSubmit" method="post">
	<s:token />
	<s:textfield label="姓名" name="emp.ename"></s:textfield>
	<s:textfield label="工资" name="emp.sal"></s:textfield>
	<s:select label="职位" list="#session.jobs" name="emp.job"></s:select>
	<s:submit value="添加"></s:submit>
</s:form>

<s:debug></s:debug> 

--%>