package com.yty.javaweb.oa.web.action;

import com.yty.javaweb.oa.utils.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // show deptno
        String deptno = request.getParameter("deptno");
        String contextPath = request.getContextPath();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>");
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<meta charset='utf-8'>");
		writer.print("<title>修改部门</title>");
		writer.print("</head>");
	    writer.print("<body>");
	    writer.print("<h1>修改部门</h1>");
		writer.print("<hr >");
        writer.print("<form action='"+contextPath+"/dept/update' method='post'>");
        try {
            conn = DBUtils.getConnection();
            String sql = "select deptno, dname, loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            if(rs.next()){

                String dname = rs.getString("dname");
                String loc = rs.getString("loc");


                writer.print("部门编号<input type='text' name='deptno' value='"+deptno+"' readonly /><br>");
                writer.print("部门名称<input type='text' name='dname' value='"+dname+"'/><br>");
                writer.print("部门位置<input type='text' name='loc' value='"+loc+"'/><br>");
                writer.print("<input type='submit' value='修改'/><br>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        writer.print("</form>");
        writer.print("</body>");
        writer.print("</html>");



    }

}
