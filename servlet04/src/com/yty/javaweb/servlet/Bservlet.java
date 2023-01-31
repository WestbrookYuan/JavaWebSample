package com.yty.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Bservlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        ServletContext servletContext = this.getServletContext();
        writer.print(servletContext);
        writer.print("<br>");
        //org.apache.catalina.core.ApplicationContextFacade@418d20c4
    }
}
