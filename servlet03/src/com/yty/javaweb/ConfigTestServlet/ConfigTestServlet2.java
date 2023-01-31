package com.yty.javaweb.ConfigTestServlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigTestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        ServletConfig servletConfig = this.getServletConfig();
        out.print(servletConfig);
        out.print("<br>");
        out.print(servletConfig.getServletName());
        out.print("<br>");
        ServletContext servletContext = servletConfig.getServletContext();
        out.print(servletContext);
        out.print("<br>");
        ServletContext servletContext1 = this.getServletContext();
        out.print(servletContext1);
        out.print("<br>");


        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            out.print(s);
            out.print("<br>");
            out.print(servletConfig.getInitParameter(s));
            out.print("<br>");
        }

    }
}
