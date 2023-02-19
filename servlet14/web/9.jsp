<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("username", "zhsangsan");
%>

<%=request.getAttribute("username")%>
<br>
${username}
<br>
<%=request.getAttribute("usernam")%>
<br>
${usernam}
<br>

${username}
<hr>
<%=request.getAttribute("userna")==null ? "": request.getAttribute("userna")%>
