<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css"></link>

<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables.bootstrap.min.js"></script>
</head>
<body style="margin-top: 50px;">
	<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
	<table id="dialog" class="table table-striped table-bordered ">
		<thead>
			<tr>
				<th>名称</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="j" value="classrooms">
				<tr>
					<td>${cname}</td>
					<td><s:property value="cdesc" /></td>
					<td>
						<s:if test="#session.account.acctype == 2 || #session.account.acctype == 3">
							<a href="delete.html?emp.empno=${empno}">删   除</a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>