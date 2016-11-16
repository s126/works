<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"></link>
<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
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
	<div>
		<h1 id="register_font">注册</h1>
		<hr>
	</div>
	<s:form action="registerSubmit" class="form-horizontal" theme="simple" >
		<table class="table">
			<tr>
				<td style="width:100px"><label class="control-label">账号：</label></td>
				<td style="width:250px"><s:textfield label="账号" name="acc.username" onchange="checkName(this)" class="form-control"/></td>
				<td style="width:270px"><s:fielderror fieldName="acc.username" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">密码：</label></td>
				<td><s:password label="密码" name="acc.password" class="form-control"/></td>
				<td><s:fielderror fieldName="acc.password" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">确认密码：</label></td>
				<td><s:password label="确认密码" name="pwd" class="form-control"/></td>
				<td><s:fielderror fieldName="pwd" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">出生日期：</label></td>
				<td><s:textfield label="生日" type="date" name="acc.birthday" class="form-control"/></td>
				<td><s:fielderror fieldName="acc.birthday" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">身份类型：</label></td>
				<td><s:select label="身份类型" name="acc.acctype" list="#session.types" class="form-control" /></td>
				<td><s:fielderror fieldName="acc.acctype" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">邮箱地址：</label></td>
				<td><s:textfield label="邮箱地址" name="acc.email" class="form-control" /></td>
				<td><s:fielderror fieldName="acc.email" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">手机号码：</label></td>
				<td><s:textfield label="手机号码" name="acc.phone" class="form-control" /></td>
				<td><s:fielderror fieldName="acc.phone" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><label class="control-label">性别：</label></td>
				<td>
					<label>
						<s:radio label="性別" name="acc.sex" list="#session.sexlist" value="3" listKey="code" listValue="name"/>
					</label>
				</td>
				<td><s:fielderror fieldName="acc.sex" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="注册" class="btn btn-success btn-block btn-lg"/></td>
			</tr>
		</table>
	</s:form>
	<div id="register">
		返回
		<a href="login.html">&nbsp;<s:text name="action.login.sbm" /></a>
	</div> 
	
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
<script type="text/javascript">
	// 判断用户名是否已经被使用
	function checkName(e) {
		$.ajax({
			url : "judgeUsername3.html",
			type : "post",
			data : {
				"acc.username" : e.value
			},
			success : function(data) {
				console.log(JSON.stringify(data));
				$("#nameinfo").text(data);
			}
		});
	}
</script>
</html>




<%-- 
<%@ include file="../pages/header.jspf" %>
	<div class="centerblock">
		<s:form action="registerSubmit">
			<s:textfield label="账号" name="acc.username" onchange="checkName(this)" />
			<span style="color:red" id="nameinfo"></span>
			<s:password label="密码" name="acc.password" />
			<s:password label="确认密码" name="pwd" />
			<s:textfield label="生日" type="date" name="acc.birthday" />
			<s:select label="身份类型" name="acc.acctype" list="#session.types"></s:select>
			<s:textfield label="邮箱地址" name="acc.email"/>
			<s:textfield label="手机号码" name="acc.phone"/>
			<s:radio label="性別" name="acc.sex" list="#session.sexlist" value="3" listKey="code" listValue="name" />
			<s:checkbox label="是否同意我们的协议" name="ok" style="margin-top: 30px;"></s:checkbox>
			<s:submit value="注册" />
		</s:form>
		<s:debug></s:debug>
	</div> 
--%>