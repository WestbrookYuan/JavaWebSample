package com.yty.javaweb.oa.web.action;

import com.yty.javaweb.oa.utils.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into dept(deptno, dname, loc) values(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        }
        finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
		
        if (count == 1){
            request.getRequestDispatcher("/dept/list").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/error.html").forward(request, response);
        }
    }

}
