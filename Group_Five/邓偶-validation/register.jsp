<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
</head>
<body>


<s:debug></s:debug>

<div class="centerblock">
	<s:form action="registerSubmit">
		<s:textfield name="acc.username" label="账号" />
		<s:password  name="acc.password" label="密码" />
		<s:password  name="acc.repassword" label="确认密码" />
		<s:textfield type="date" name="acc.birthday" label="出生日期" />	
		<s:textfield type="email" name="acc.email" label="邮箱" />
		<s:textfield type="phone" name="acc.phone" label="手机号码" />
		<s:radio list="#{1:'男',2:'女' }" label="性别" name="acc.sex" value="1" />
		<s:submit value="注册" />
	</s:form>
</div>
</body>
</html>