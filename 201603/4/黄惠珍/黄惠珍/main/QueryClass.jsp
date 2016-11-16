<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示所有班级信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dataTables.bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css"></link>
<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables.bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
	<pre>
	<a href="addStu" class="btn btn-primary btn-sm">
		<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加学生
	</a>
	</pre>
	<pre>
	<a href="addTea" class="btn btn-primary btn-sm">
		<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加老师
	</a>
	</pre>
	<pre>
	<a href="addClass" class="btn btn-primary btn-sm">
		<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加班级
	</a>
	</pre>
	<table id="dialog" class="table table-striped table-bordered ">
		<thead>
			<tr>
				<th>班级</th>
				<th>班级描述</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="c" value="classroom">
				<tr>
					<td>${cname}</td>
					<td><s:property value="cdesc" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>