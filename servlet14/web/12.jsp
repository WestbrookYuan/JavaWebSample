<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%
    request.setAttribute("s", "sb");

    ServletRequest request1 = pageContext.getRequest();
%>


${s}
\${s}
<br>

${pageContext.request.session}
<br>
<%=request1%>
<br>
<%=request%>

