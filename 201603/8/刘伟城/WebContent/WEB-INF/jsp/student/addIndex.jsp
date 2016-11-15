<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生</title>
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
	<h1>添加学生</h1><hr>
	<s:form action="addStudent" method="post" class="form-horizontal" theme="simple">
		<s:token />
		<table class="table">
			<tr>
				<td><label class="control-label">学生姓名：</label></td>
				<td><s:textfield name="student.name" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">生日：</label></td>
				<td><s:textfield type="Date" name="student.birth" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">性别：</label></td>
				<td><s:radio list="#{'1':'男','2':'女'}" value="1" name="student.sex" ></s:radio> </td>
			</tr>
			<tr>
				<td><label class="control-label">所在教室：</label></td>
				<td><s:select list="classrooms" label="所在教室" name="student.classroom.crid" listKey="crid" listValue="cname" ></s:select></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="添加" class="btn btn-success btn-block"/></td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>