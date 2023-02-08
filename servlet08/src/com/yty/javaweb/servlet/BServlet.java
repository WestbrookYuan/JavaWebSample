package com.yty.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object date = req.getAttribute("date");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print(date.toString() + "<br>");

    }
}
