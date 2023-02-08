package com.yty.javaweb.oa.web.action;

import com.yty.javaweb.oa.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<!DOCTYPE html>");
        writer.print("<html>");
        writer.print("<head>");
	    writer.print("<meta charset='utf-8'>");
		writer.print("<title>部门详情</title>");
		writer.print("</head>");
	    writer.print("<body>");
        writer.print("<h1>部门详情</h1>");
        writer.print("<hr >");

        try{
            conn = DBUtils.getConnection();
            String sql = "Select dname, loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                writer.print("部门编号: " + deptno + " <br>");
                writer.print("部门名称："+dname+"<br>");
                writer.print("部门位置："+loc+"<br>");

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        writer.print("<input type='button' value='后退' onclick='window.history.back()'/>");
        writer.print("</body>");
	    writer.print("</html>");

    }
}
