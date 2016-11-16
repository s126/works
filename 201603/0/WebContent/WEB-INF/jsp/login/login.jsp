<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="action.login.title" /></title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
<style>
	.table{
		margin: 0 auto;
		width: 0;
	}
	.table tr td {
		border: none !important;
	}  
</style>
</head>
	<body>
		<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
		<div id="logo">
			<img src="${pageContext.request.contextPath }/img/logo.png">
		</div>
		<s:form action="loginSubmit" class="form-horizontal" theme="simple" >
			<table class="table">
				<tr>
					<td><label class="control-label">账号 ：</label></td>
					<td style="width:270px">
						<s:textfield name="name" key="action.login.name"  autocomplete="off" class="form-control input-lg" />
						<s:fielderror fieldName="name"  cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td><label class="control-label">密码 ：</label></td>
					<td>
						<s:password name="pwd" key="action.login.pwd" class="form-control input-lg"/>
						<s:fielderror fieldName="pwd"  cssStyle="color:red" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><s:submit key="action.login.sbm" class="btn btn-success btn-block btn-lg"/></td>
				</tr>
			</table>
			<s:token></s:token>
		</s:form>
		<div id="register">
			<s:text name="action.login.gotoregister" />
			<a href="register.html">&nbsp;<s:text name="action.register" /></a>
		</div>
		
		
	</body>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</html>


<%-- 
<%@ include file="../pages/header.jspf" %>
<jsp:include page="/WEB-INF/jsp/pages/header.jspf" />  
<div class="centerblock">
	<s:form action="loginSubmit" class="form-horizontal">
		<s:textfield name="name" key="action.login.name" autocomplete="off"/>
		<s:password name="pwd" key="action.login.pwd" />
		<s:submit key="action.login.sbm" />
		<s:token></s:token>
	</s:form>
</div>

<div><s:text name="action.login.gotoregister" /><a href="register.html">&nbsp;<s:text name="action.register" /></a></div>
<s:debug></s:debug>
 --%>