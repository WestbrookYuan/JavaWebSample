package com.yty.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Dservlet extends GenerateServlet{

    @Override
    public void init(){
        System.out.println("重写了");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("D");
        ServletConfig config  = this.getServletConfig();
        System.out.println("config: " + config);
    }
}
