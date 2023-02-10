package com.yty.javaweb.servlet;

import com.yty.javaweb.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId("1");
        user.setName("jack");
        String contextPath = req.getContextPath();
        req.setAttribute("userobj", user);
//        req.getRequestDispatcher("/b").forward(req, resp);
        resp.sendRedirect(contextPath+"/b");
    }

}
