<%@ page import="com.yty.javaweb.Bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


Server info（Tomcat服务器信息）: <%=application.getServerInfo() %><br>
Servlet version（Servlet版本）: <%=application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
JSP version（JSP版本）: <%=JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
Java version（Java版本）: <%=System.getProperty("java.version") %><br>





<%
    List<User> userList = new ArrayList<User>();
    User user1 = new User("1", "2");
    User user2 = new User("3", "4");
    User user3 = new User("5", "6");
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    request.setAttribute("userList", userList);
%>

<c:forEach items="${userList}" var="user">
    ${user.username} ${user.password}
    <br>
</c:forEach>

<%--<%--%>
<%--    List<User> users = (ArrayList<User>)request.getAttribute("userList");--%>
<%--    for (User user : users) {--%>
<%--%>--%>
<%--<%=--%>
<%--    user--%>
<%--%>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>


