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

	<div class="centerblock">
		<s:form action="registerSubmit">
			<s:textfield label="账号" name="acc.username" />
			<s:textfield label="密码" name="acc.password" />
			<s:textfield label="确认密码" name="pwd" />
			<s:textfield label="生日" type="date" name="acc.birthday" />
			<s:radio label="性别" list="#{0:'男',1:'女'} " value="0" name="acc.sex"></s:radio>
			<s:textfield label="邮箱"  name="acc.email" />			
			<s:textfield label="电话号码"  name="acc.phone" />
			<s:select label="类型" name="acc.acctype" list="#{1:'学生', 2:'老师', 3:'校长'}"></s:select>
			<s:submit value="注册" />
		</s:form>
	</div>
	
	
	<s:debug></s:debug>
</body>
</html>