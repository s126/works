<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>添加一个老师</title>
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
	<h1>添加老师</h1><hr>
	<s:form action="addTea" method="post" class="form-horizontal" theme="simple">
		<s:token />
		<table class="table">
			<tr>
				<td><label class="control-label">姓名：</label></td>
				<td><s:textfield label="姓名" name="teacher.tname" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">电话：</label></td>
				<td><s:textfield label="电话" name="teacher.tel" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">所教班级：</label></td>
				<td><s:select label="所教班级" name="classroom.cname" list="#session.cname" class="form-control" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="添加" class="btn btn-success btn-block"/></td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>
