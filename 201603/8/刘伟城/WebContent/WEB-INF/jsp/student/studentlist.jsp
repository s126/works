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
				<th>姓名</th>
				<th>性别</th>
				<th>所在教室</th>
				<th>生日</th>
				
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="j" value="studentLists">
				<tr>
					<td>${name}</td>
					<td>${sex == 1?'男':'女'}</td>
					<td><s:property value="#j.classroom.cname"/> </td>
					<td><s:date name="birth" format="yyyy-MM-dd" /> </td>
					<td>
						<a href="lookTeacher.html?crid=<s:property value="#j.classroom.crid"/>">查看老师</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
	<s:debug></s:debug>
</body>
</html>