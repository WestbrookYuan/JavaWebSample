<%@ page contentType="text/html;charset=UTF-8" %>

<%
    request.setAttribute("username", "zhangsan");
    request.setAttribute("obj", new Object());
%>

<%=request.getAttribute("username")%>
<br>
<%=request.getAttribute("obj")%>
<br>

${username}
<br>
${obj}