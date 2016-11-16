<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示所有员工信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dataTables.bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css"></link>
<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables.bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/jsp/pages/header.jspf" %>
	<div id="seek">
		<!-- 用 AJAX的方式实现 -->
		<div style="float:left">
			<s:textfield id="sname" class="form-control form-control-input input-sm" cssStyle="width:150px" placeholder="请输入姓名或工作"/>
			<button type="button" id="search" class="btn btn-success btn-sm">
				<i class="glyphicon glyphicon-search"></i>&nbsp;&nbsp;ajax搜索
			</button>
		</div>
		<!-- 用 Form 表单的形式实现 -->
		<div style="float:left">
			<s:form action="filter" theme="simple">
				<div>
					<s:textfield name="input"  class="form-control form-control-input input-sm" cssStyle="width:150px" placeholder="请输入姓名或工作"/> 
					<button type="submit"  class="btn btn-success btn-sm">
						<i class="glyphicon glyphicon-search"></i>&nbsp;&nbsp;form搜索
					</button>
				</div>
			</s:form>
		</div>
		<!-- 工资搜索 -->
		<div>
			<s:form action="filterSal" theme="simple">
				<s:textfield name="min" type="number" class="form-control form-control-input input-sm" cssStyle="width:150px" placeholder="请输入工资"/> 
				- 
				<s:textfield name="max" type="number" class="form-control form-control-input input-sm" cssStyle="width:150px" placeholder="请输入工资"/>
				<button type="submit" value="按照工资范围搜索" class="btn btn-success btn-sm">
					<i class="glyphicon glyphicon-search"></i>&nbsp;&nbsp;工资范围搜索
				</button>
				<div style="color:red;display:inline">${fieldErrors.max[0]}</div>
			</s:form>
		</div>
	</div>
	<pre>
	<a href="addIndex" class="btn btn-primary btn-sm">
		<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加员工
	</a>
	</pre>
	<table id="dialog" class="table table-striped table-bordered ">
		<thead>
			<tr>
				<th>姓名</th>
				<th>工作</th>
				<th>工资</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="j" value="emps">
				<tr>
					<td>${ename}</td>
					<td><s:property value="job" /></td>
					<td><s:property value="#j.sal" /></td>
					<td>
						<s:if test="#session.account.acctype == 2 || #session.account.acctype == 3">
							<a href="delete.html?emp.empno=${empno}">删   除</a>
						</s:if>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/jsp/pages/footer.jspf" %>
</body>
<script>
	$(function(){
		$("#search").on(
			"click",
			function() {
				var ename = $("#sname").val();
				$.ajax({
					url : 'searchEmp.html',
					type : 'post',
					data : {
						'input' : ename
					},
					success : function(data) {
						var html = "";
						html +="<table class='table table-striped table-bordered'>";
						html += "<thead>";
							html += "<tr>";
								html += "<th>姓名</th>";
								html += "<th>工作</th>";
								html += "<th>工资</th>";
								html += "<th>操作</th>";
							html += "</tr>";
						html += "</thead>";
							html += "<tbody>";
								for ( var i in data) {
									html += "<tr>";
									html += " <td>" + data[i].ename + "</td>";
									html += " <td>" + data[i].job + "</td>";
									html += " <td>" + data[i].sal + "</td>";
									<s:if test="#session.account.acctype == 2 || #session.account.acctype == 3">
									html += "<td><a href='delete.html?ename="
											+ data[i].ename + "'>删除</a></td>"
									</s:if>
									html += "</tr>";
								}
							html += "</tbody>";
						html+="</table>";
						$("#dialog").html(html);
						
						
					},
					error : function() {
						alert(发送失败);
					}
				});
			});
	});
	/* database */
	$(document).ready(function() {
	   $('#dialog').DataTable({
	    	"aoColumnDefs": [{ 
	    		"bSortable": false, "aTargets": [3] 
	    	}] 
	    });
	} );
</script>
</html>
<%-- 
	<s:debug></s:debug>
	
	<!-- 用 AJAX的方式实现 -->
	<div>
		<s:textfield id="sname" /><input type="button" id="search" value="搜索(AJAX)" />
	</div>

	<!-- 用 Form 表单的形式实现 -->
	<div>
		<s:form action="filter" theme="simple">
			<s:textfield name="input" /> <s:submit value="搜索(FORM)" />
		</s:form>
	</div>

	<div>
		<div style="color:red">${fieldErrors.max[0]}</div>
		<s:form action="filterSal" theme="simple">
			<s:textfield name="min" type="number" /> - 
			<s:textfield name="max" type="number" />
			<s:submit value="按照工资范围搜索" />
		</s:form>
	</div>
	<a href="addIndex">添加员工</a>

	<table id="dialog">
		<tr>
			<td>姓名</td>
			<td>工作</td>
			<td>工资</td>
		</tr>

		<s:iterator var="j" value="emps">
			<tr>
				<td>${ename}</td>
				<td><s:property value="job" /></td>
				<td><s:property value="#j.sal" /></td>
				<td><a href="delete.html?emp.empno=${empno}">删   除</a></td>
			</tr>
		</s:iterator>

	</table>
 --%>
