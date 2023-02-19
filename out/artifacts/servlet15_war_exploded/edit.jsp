<%@ page import="oa.bean.Department" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset='utf-8'>
		<title>修改部门</title>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
	</head>
	<body>
		<h1>修改部门</h1>
		<hr >
		<form action='dept/update' method='get'>

			部门编号<input type='text' name='deptno' value=${dept.deptno} readonly > <br>
			部门名称<input type='text' name='dname' value=${dept.dname}> <br>
			部门位置<input type='text' name='loc' value=${dept.loc}><br>
			<input type='submit' value='修改'/><br>
		</form>
	</body>
</html>
