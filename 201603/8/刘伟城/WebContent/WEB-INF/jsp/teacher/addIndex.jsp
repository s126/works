<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>添加老师</title>
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
<body style="margin-top: 50px;">
	<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
	<h1>添加老师</h1><hr>
	<s:form action="addTeacher" method="post" class="form-horizontal" theme="simple">
		<s:token />
		<table class="table">
			<tr>
				<td><label class="control-label">老师姓名：</label></td>
				<td><s:textfield label="老师姓名" name="teacher.tname" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">电话号码：</label></td>
				<td><s:textfield label="电话号码" name="teacher.tel" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">所在教室：</label></td>
				<td><s:select list="classrooms" label="所在教室" name="teacher.classroom.crid" listKey="crid" listValue="cname" ></s:select></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="添加" class="btn btn-success btn-block"/></td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>