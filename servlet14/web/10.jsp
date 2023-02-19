<%@ page import="com.yty.javaweb.Bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  User user = new User();
  user.setUsername("zhangsan");
  request.setAttribute("user.syb", user);
%>

${user.username}
${user["username"]}

${requestScope["user.syb"]}