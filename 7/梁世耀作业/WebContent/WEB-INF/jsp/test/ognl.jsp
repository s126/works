<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OGNL 测试</title>
</head>
<body>

<s:debug></s:debug>

<div>
	我的名字：
	<s:property value = "myname"/>
</div>
<div>
	<p>小月月的名字：
	<s:property value="xiaoyueyue.name"/></p>${xiaoyueyue.name }
	<p>小月月的名字：
	<s:property value="xiaoyueyue.age"/></p>${xiaoyueyue.age }
	
	<p>小月月的电脑型号：
	<s:property value="xiaoyueyue.comp.type"/></p>${xiaoyueyue.comp.type }
	
	小月月的电脑外号：
	<s:property value="xiaoyueyue.comp.alias" />
	
	<s:iterator var="i" value="xiaoyueyue.comp.alias">
		<s:iterator var="j" value="xiaoyueyue.comp.alias">
			<div>
				<s:property value="#i.length()" /><s:property value="#j" />
			</div>
		</s:iterator>
	</s:iterator>
	
</div>

<div>
	<s:property value="#session.flag1" />
	<s:property value="#session.flag2" />
	<s:property value="#session.flag3" />
	<s:property value="#request.flag4" />
</div>

</body>
</html>