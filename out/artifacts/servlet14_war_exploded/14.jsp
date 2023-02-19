<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="com.yty.javaweb.Bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${10 + 20}
<br>
${"10" + "20"}
<%--\${10 + "abc"}--%>

<%--\${"kinf" + "soft"}--%>
<br>
${"abc" == "abc"}<br>
${"abc"} == ${"abc"}<br>

<%
    Object obj = new Object();
    request.setAttribute("obj1", obj);
    request.setAttribute("obj2", obj);
%>

${obj1 == obj2}
<br>

<%
    String string = "sb";
    request.setAttribute("a", obj);
    request.setAttribute("b", obj);
%>

${a == b}
<br>

<%
    Object obj1 = new Object();
    Object obj2 = new Object();
    request.setAttribute("o1", obj1);
    request.setAttribute("o2", obj2);
%>

${o1 == o2}
<br>

<%
    User user1 = new User();
    User user2 = new User();
    user1.setUsername("1");
    user2.setUsername("2");
    request.setAttribute("user1", user1);
    request.setAttribute("user2", user2);
%>

${user1 == user2}
<br>
${user1 != user2}
<br>