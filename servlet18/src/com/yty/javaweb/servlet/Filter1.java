package com.yty.javaweb.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.File;
import java.io.IOException;
//@WebFilter(urlPatterns = {"*.do"})
public class Filter1 implements Filter {

    public Filter1(){
        System.out.println("1");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3");
        chain.doFilter(request, response);
        System.out.println("4");
    }

    @Override
    public void destroy() {
        System.out.println("3");
    }
}
