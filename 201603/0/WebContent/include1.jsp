<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<div>这是include1.jsp</div>
	
	<%-- <%@ include file="include2.jsp"%> --%> 

 	<jsp:include page="include2.jsp" flush="true"/>
</body>
</html>