package com.yty.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "hello",urlPatterns = {"/hello", "/hello2"},
initParams = {@WebInitParam(name = "username", value = "root"), @WebInitParam(name = "password", value = "123")})
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        System.out.println("gaga");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        String servletName = getServletName();
        writer.print("servlet name: " + servletName + "<br>");
        String servletPath = request.getServletPath();
        writer.print("servlet path: " + servletPath + "<br>");

        Enumeration<String> initParameterNames = getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            String val = getInitParameter(key);
            writer.print("key: " + key + " val:" + val + "<br>");
        }



    }
}
