package com.yty.javaweb.ConfigTestServlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        ServletConfig config = getServletConfig();
        out.print("servlet" + config.getInitParameterNames());
    }
}
