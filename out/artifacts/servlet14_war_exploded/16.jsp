<%@ page import="com.yty.javaweb.Bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty param.username}">
    <h1>sb</h1>

</c:if>

<c:if test="${!(empty param.username)}" var="v" scope="request">
    <h1>ni hao ${param.username}</h1>

</c:if>

${v}

<hr>

<c:forEach begin="1" end="10" step="2" var="i">
    ${i}
</c:forEach>

<hr>

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

<c:forEach items="${userList}" var="user" varStatus="userStatus">
    ${userStatus.count} ${user.username} ${user.password}
    <br>

</c:forEach>


<c:choose>
    <c:when test="${param.age < 18}">
        <h1>1</h1>
    </c:when>
    <c:when test="${param.age < 35}">
        <h1>2</h1>
    </c:when>
    <c:when test="${param.age < 55}">
        <h1>3</h1>
    </c:when>
    <c:otherwise>
        <h1>4</h1>
    </c:otherwise>
</c:choose>