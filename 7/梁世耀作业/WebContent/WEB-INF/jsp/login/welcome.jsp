<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:debug/>

<div style="width:500px; margin:0 auto; border:1px solid #999; padding:10px;">
	<p>欢迎：<s:property  value="acc.username"/>来到首页</p>
	<p>你的用户类型为：
		<s:if test="acc.acctype==1">
			学生
		</s:if>
		<s:if test="acc.acctype==2">
			老师
		</s:if>
		<s:if test="acc.acctype==3">
			校长
		</s:if>
	</p>
	<p>你的生日为：<s:date nice="false"  format="yyyy-MM-dd" name="acc.birthday"/> </p>
	
</div>



</body>
</html>