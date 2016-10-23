<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	您好：${name}<br>
	<s:if test="sex==0">
		性别：男<br>
	</s:if>
	<s:else>
		性别：女<br>
	</s:else> 
	出生日期：<s:date name="birthday" format="yyyy-MM-dd"/><br>
	电话：${photonum}<br>
	邮件：${email}<br>
	<s:if test="acctype==1">
		类型：学生<br>
	</s:if>
	<s:elseif test="acctype==2">
		类型：老师<br>
	</s:elseif> 
	<s:else>
		类型：校长<br>
	</s:else>
</body>
</html>