package com.yty.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/cookie/generate"})
public class Generate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("productid", "1234567");
        Cookie cookie2 = new Cookie("username", "zhangsan");
        cookie.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
