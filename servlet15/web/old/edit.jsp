<%@ page import="oa.bean.Department" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset='utf-8'>
		<title>修改部门</title>
	</head>
	<body>
		<h1>修改部门</h1>
		<hr >
		<form action='<%=request.getContextPath()%>/dept/update' method='get'>
			<%
				Department dept = (Department) request.getAttribute("dept");

			%>
			部门编号<input type='text' name='deptno' value=<%=dept.getDeptno()%> readonly /><br>
			部门名称<input type='text' name='dname' value=<%=dept.getDname()%>><br>
			部门位置<input type='text' name='loc' value=<%=dept.getLoc()%>><br>
			<input type='submit' value='修改'/><br>
		</form>
	</body>
</html>
