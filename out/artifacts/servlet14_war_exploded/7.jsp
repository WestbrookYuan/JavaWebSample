<%@ page import="com.yty.javaweb.Bean.User" %>
<%@ page import="com.yty.javaweb.Bean.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = new User();
    user.setUsername("zhangsan");
    user.setPassword("123456");

    Address address = new Address();
    address.setCity("Beijing");
    address.setStreet("haha");
    address.setPostalCode("134");
    user.setAddress(address);
    request.setAttribute("user", user);
    request.setAttribute("address", address);
%>

${user}
<br>

${user.username}
<br>
${user.email}
<br>
${user.address.street}
<br>
${user.address.city}
<br>
${user.address.postalCode}
