<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ALL student</title>
</head>
<body>

		
        <h1>添加学生</h1>
		<form action='add.do' method='post' name="frm" >
		<table border="1">	
		    <tr>
				<td class="text_right">学号：</td>
				<td class="myinput"><input type="text" name="id"   /></td>
			</tr>		
			<tr>
				<td class="text_right">姓名：</td>
				<td class="myinput"><input type="text" name="name"  /></td>
			</tr>
			<tr>
				<td class="text_right">性别：</td>
				<td class="myinput"><input type="text" name="sex"  /></td>
			</tr>
			<tr>
				<td class="text_right">入住日期：</td>
				<td class="myinput"><input type="text" name="date1"  /></td>
			</tr>
			<tr>
				<td class="text_right">退宿日期：</td>
				<td class="myinput"><input type="text" name="date2"   /></td>
			</tr>
			<tr>
				<td class="text_right">宿舍编号</td>
				<td class="myinput"><input type="text" name="s2"   /></td>
			</tr>
			<tr>
			<td colspan="6" style="text-align:center;"><input type="submit"  onclick="get()" value="提交"></td>
			</tr>
	     </table>
	     </form>
</body>
</html>