package com.yty.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = {"/sendCookie"})
public class ReceiveCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (cookies != null){
            for(Cookie cookie:cookies){
                out.print(cookie.getName());
                out.print("<br>");
                out.print(cookie.getValue());
                out.print("<br>");
            }
        }


    }
}
