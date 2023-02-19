<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.yty.javaweb.Bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, String> map = new HashMap<String, String>();
    map.put("user", "name");
    map.put("pass", "word");
    request.setAttribute("map", map);


    Map<String, User> map2 = new HashMap<String, User>();
    map2.put("user", new User("zhangsan", "123"));
    request.setAttribute("map2", map2);

    String[] array = new String[]{"shab", "shabi,", "sha"};
    request.setAttribute("array", array);
%>

${map.user}
<br>
${map.pass}
<hr>

${map["user"]}
<br>
${map["pass"]}
<hr>

${map2["user"]["username"]}

<hr>

${array[0]}
${array[1]}
${array[2]}
${array[3]}