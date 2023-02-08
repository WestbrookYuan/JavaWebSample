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

public class DeptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        writer.print("<!DOCTYPE html>");
        writer.print("<html>");
        writer.print("<head>");
        writer.print("<meta charset='utf-8'>");
        writer.print("<title>部门列表页面</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<script type='text/javascript'>");
        writer.print("function del(dno){");
        writer.print("var ok = window.confirm('亲，删了不可恢复哦！');");
        writer.print(" if(ok){");
        writer.print("document.location.href = '/servlet10/dept/delete?deptno=' + dno;");
        writer.print("}");
        writer.print("}");
        writer.print("</script>");
        writer.print("<h1 align='center'>部门列表</h1>");
        writer.print("<hr >");
        writer.print("<table border='1px' align='center' width='50%'>");
		writer.print("<tr>");
		writer.print("<th>序号</th>");
        writer.print("<th>部门编号</th>");
        writer.print("<th>部门名称</th>");
        writer.print("<th>操作</th>");
        writer.print("</tr>");

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("Select deptno, dname, loc from dept");
            rs = ps.executeQuery();
            int i =0;

            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                writer.print("<tr>");
                writer.print("<td>" + (++i) + "</td>");
                writer.print("<td>"+deptno+"</td>");
                writer.print("<td>"+dname+"</td>");
                writer.print("<td>");
                writer.print("<a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                writer.print("<a href='edit.html'>修改</a>");
                writer.print("<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                writer.print("</td>");
                writer.print("</tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        writer.print("</table>");
        writer.print("<hr >");
        writer.print("<a href='/servlet10/add.html'>新增部门</a>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
