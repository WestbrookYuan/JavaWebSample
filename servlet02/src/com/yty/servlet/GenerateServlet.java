package com.yty.servlet;

import javax.servlet.*;
import java.io.IOException;

public abstract class GenerateServlet implements Servlet {


    private ServletConfig config;

    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        this.init();
    }

    public void init() {
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
