<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>添加一个班级</title>
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
	<h1>添加班级</h1><hr>
	<s:form action="addClass" method="post" class="form-horizontal" theme="simple">
		<s:token />
		<table class="table">
			<tr>
				<td><label class="control-label">班名：</label></td>
				<td><s:textfield label="姓名" name="classroom.cname" class="form-control" /></td>
			</tr>
			<tr>
				<td><label class="control-label">描述：</label></td>
				<td><s:textfield label="描述" name="classroom.cdesc" class="form-control" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="添加" class="btn btn-success btn-block"/></td>
			</tr>
		</table>
	</s:form>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>
