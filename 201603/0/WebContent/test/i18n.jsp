<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<s:textarea key="dddd"></s:textarea>
<s:password key="" name=""/>
	显示加载的国际化资源文件
	line1:<s:text name="line1" />
	line2:<s:text name="line2" />
	line3:
		  <s:text name="line3" >
		  	<s:param>a</s:param>
		  	<s:param>b</s:param>
		  	<s:param>c</s:param>
		  </s:text>     
	<s:form>
		<s:textfield  name="line1" key=" "></s:textfield>
		<s:textfield name="line2" key="line2"></s:textfield>
	</s:form>
	<a href="http://localhost:8088/hello/test/i18n.action?request_locale=en">英文</a>
	<a href="http://localhost:8088/hello/test/i18n.action?request_locale=zh_CN">中文</a>
	
	<s:debug />
</body>
</html>