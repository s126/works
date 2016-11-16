<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-json-tags"  prefix="cc" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
<s:if test="#request.msg">
<script>
	alert('${request.msg}');
</script>
</s:if>
</head>
<body>
<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
<div id="main" style="width: 400px;">
	<header>
		<h1 style="text-align: center">商品管理系统</h1>
		<s:form theme="simple">
			<span><a href='<s:url action="addindex" />'>添加商品</a></span>
			<span style="float: right;">查询 <s:select name="item.status" list="#{-1:'请选择',0:'上架',1:'下架'}" onchange="submit()"></s:select></span>
		</s:form>
	</header>
	<section>
		<table style="width:100%;">
			<tr><th>商品名称</th><th>价格</th><th>录入时间</th><th>状态</th><th>操作</th></tr>
			
			<s:iterator value="items">
				<tr>
					<td>${name}</td>
					<td>${price}</td>
					<td><s:date name="cdate" format="yyyy-MM-dd" /> </td>
					<s:if test="status==0">
						<td>已上架</td>
						<td><a href='/hello/items/down.action?item.id=${id}&item.status=<s:property value="#parameters['item.status][0]'" />'>下架</a></td>
					</s:if>
					<s:else>
						<td>已下架</td>
						<td><a href='/hello/items/up.action?item.id=${id}&item.status=<s:property value="#parameters['item.status'][0]" />'>上架</a></td>
					</s:else>
				</tr>
			</s:iterator>
		</table>
	</section>

</div>

<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
<%-- <s:debug></s:debug> --%>



</body>
</html>