<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    pageContext.setAttribute("user", "1");
    request.setAttribute("user", "2");
    session.setAttribute("user", "3");
    application.setAttribute("user", "4");
%>

${pageScope.user}
<br>
${requestScope.user}
<br>
${sessionScope.user}
<br>
${applicationScope.user}
<br>