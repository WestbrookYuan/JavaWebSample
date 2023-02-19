<%@ page import="com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl" %>
<%@ page import="oa.bean.Department" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门详情</title>
	</head>
	<body>
		<h1>部门详情</h1>
		<%
			Department dept = (Department) request.getAttribute("dept");
		%>
		<hr >
		部门编号：<%=dept.getDeptno()%> <br>
		部门名称：<%=dept.getDname()%><br>
		部门位置：<%=dept.getLoc()%><br>
		
		<input type="button" value="后退" onclick="window.history.back()"/>
	</body>
</html>
