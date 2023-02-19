<%@ page contentType="text/html;charset=UTF-8" language="java" %>

${pageContext.request.contextPath}

<br>

<%--<%=request.getParameter("username")%>--%>
<%--<br>--%>

<%--${param.username}--%>


<%--${param.aihao}--%>
<br>
${paramValues.aihao[0]}
<br>
${paramValues.aihao[1]}
<br>
<%--${paramValues.aihao[2]}--%>
<br>
<%=application.getInitParameter("pageSize")%>

${initParam.pageSize}
