package com.yty.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bservlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        ServletContext servletContext = this.getServletContext();
        writer.print(servletContext + "<br>");
        //org.apache.catalina.core.ApplicationContextFacade@418d20c4
        Enumeration<String> attributeNames = servletContext.getInitParameterNames();
        while (attributeNames.hasMoreElements()){
            String param = attributeNames.nextElement();
            String val = servletContext.getInitParameter(param);
            writer.print(param + " " + val);
            writer.print("<br>");
        }
        String contextPath = servletContext.getContextPath();
        writer.print(contextPath + "<br>");
        String realPath = servletContext.getRealPath("/index.html");
        writer.print(realPath);
        writer.print("<br>");
        String realPath1 = servletContext.getRealPath("/common/common.html");
        writer.print(realPath1);
        writer.print("<br>");
        servletContext.log("yeah");

//        int age = 17;
//        if (age < 18){
//            servletContext.log("not", new RuntimeException("xiao"));
//        }

//        FileInputStream stream = new FileInputStream(realPath);

        User user = new User("jack", "123");
        servletContext.setAttribute("user", user);
        writer.print(servletContext.getAttribute("user") + "<br>");
    }
}
