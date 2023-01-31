package com.yty.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Aservlet implements Servlet {
    public Aservlet(){
        System.out.println("A");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init execute");
    }

    @Override
    public void destroy() {
        System.out.println("destroy!");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service execute");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

}
