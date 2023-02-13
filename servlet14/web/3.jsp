<%--
  Created by IntelliJ IDEA.
  User: yuantengyan
  Date: 2/11/23
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    System.out.println(i);
%>
<%!
    public static int i = 10;
    static {
        System.out.println("sb");
    }
    public static void m1(){
        System.out.println("m1 sb");
    }
%>