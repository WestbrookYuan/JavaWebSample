<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎使用OA系统</title>
	</head>
	<body>
	<h1>Login Page</h1>

<%--		 <a href="<%=request.getContextPath()%>/dept/list">查看部门列表</a>--%>
	<form action="<%=request.getContextPath()%>/user/login" method="post">
		Username: <label>
		<input type="text" name="username">
		</label>
		<br>
		Password: <label>
		<input type="password" name="password">
		</label>
		<br>
		<input type="submit" value="login">
	</form>

	</body>
</html>
