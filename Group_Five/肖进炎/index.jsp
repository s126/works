<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>注册</title>
  </head>
  <body>
   <div class="centerblock">
   <s:form action="t">
		<s:textfield name="Email" label="邮箱"></s:textfield>
		<s:textfield name="phone" label="手机"></s:textfield>
		<s:textfield name="Sex" label="性别"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form>
	<s:debug></s:debug>
</div>
  </body>
</html>
