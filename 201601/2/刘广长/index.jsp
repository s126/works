<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>验证</title>
</head>
<body>
<div style="width:500px; border:1px solid #999; margin: 0 auto; padding:30px;">
	 
	<s:form action="index" namespace="/test" name="for">
		<s:textfield name="email" label="邮箱"/>
		<s:textfield name="phone"  label="电话号码" />
		
		<s:textfield name="tex" value="fsdf" label="hes" readonly="true" />
		
		<s:checkboxlist list="#{1:'足球',2:'篮球',3:'羽毛球'}" name="love" label="爱好"/>  
		
		<s:radio label="性别" name="sex" list="#{'1':'男','0':'女'}" value="1" labelposition="top" />
		
		<s:select name="fuzhuang" multiple="true" labelposition="top" list="#{'1':'男装','2':'女装'}" label="服装类型" headerKey="-1" headerValue="服装" />
		
		<s:select name="aa"  list="{}" label="歌手" headerKey="-1" headerValue="--歌手--" >  
         	<s:optgroup list="#{1:'刘德华',2:'成龙',3:'周华健'}" label="男歌手" />  
        	<s:optgroup list="#{1:'那英',2:'刘若英',3:'王心凌'}" label="女歌手" />  
   		</s:select>  
   		 
    	<s:combobox list="{'朋友','同学','家人','陌生人'}" name="getInfo" label="关系"/>
    	 
		<s:submit value="验证"/>
	</s:form>
	
	

</div>
	
</body>
</html>