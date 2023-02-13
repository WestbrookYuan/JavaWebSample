package com.yty.javaweb.oa.web.action;

import com.yty.javaweb.oa.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String deptno = req.getParameter("deptno");

        try{
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            count = ps.executeUpdate();
            conn.commit();
        }
        catch (Exception e){
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        }
        finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (count == 1){
            resp.sendRedirect(req.getContextPath() + "/dept/list");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/error.html");
        }

    }
}
