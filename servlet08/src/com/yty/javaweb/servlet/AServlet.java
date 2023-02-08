package com.yty.javaweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("date", new Date());
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/b");
//        requestDispatcher.forward(req, resp);
        req.getRequestDispatcher("/test.html").forward(req, resp);
    }
}
