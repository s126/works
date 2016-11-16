<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增商品</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
</head>
<body>
<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
<div id="main">
	<s:a href="list">返回</s:a>
	<s:form action="add" namespace="/items">
		<s:textfield label="商品名字" name="item.name"></s:textfield>
		<s:textfield label="价格" type="number" name="item.price"></s:textfield>
		<s:textfield label="创建日期" type="date" name="item.cdate"></s:textfield>
		<s:radio label="状态" name="item.status" list="#{0:'上架', 1:'下架'}"></s:radio>
		<s:submit value="添加"></s:submit>
	</s:form>
</div>
<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
</html>