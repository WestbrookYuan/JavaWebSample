package oa.web.action;

import oa.bean.Department;
import oa.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/dept/list", "/dept/delete", "/dept/add", "/dept/edit", "/dept/update", "/dept/detail"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTf-8");
//        HttpSession session = request.getSession(false);
//        if (session == null && session.getAttribute("username") == null){
//            response.sendRedirect(request.getContextPath());
//        }
//        else {
        String servletPath = request.getServletPath();
        if (servletPath.equals("/dept/list")) {
            doList(request, response);
        } else if (servletPath.equals("/dept/detail")) {
            doDetail(request, response);
        } else if (servletPath.equals("/dept/delete")) {
            doDel(request, response);
        } else if (servletPath.equals("/dept/add")) {
            doAdd(request, response);
        } else if (servletPath.equals("/dept/edit")) {
            doEdit(request, response);
        } else if (servletPath.equals("/dept/update")) {
            doUpdate(request, response);
        }
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            String sql = "update dept set dname=?, loc=? where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, loc);
            ps.setString(3, deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (count == 1) {
            try {
                resp.sendRedirect(req.getContextPath() + "/dept/list");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/error.html");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "select deptno, dname, loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            String deptno = req.getParameter("deptno");
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            Department department = null;
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                department = new Department(deptno, dname, loc);
            }
            req.setAttribute("dept", department);
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void doAdd(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            String deptno = req.getParameter("deptno");
            String dname = req.getParameter("dname");
            String loc = req.getParameter("loc");
            String sql = "insert into dept(deptno, dname, loc) values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtils.close(conn, ps, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (count == 1) {
            try {
                resp.sendRedirect(req.getContextPath() + "/dept/list");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doDel(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();
            String deptno = req.getParameter("deptno");
            String sql = "delete from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DBUtils.close(conn, ps, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (count == 1) {
            try {
                resp.sendRedirect(req.getContextPath() + "/dept/list");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/error.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doDetail(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "select deptno, dname, loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            String deptno = req.getParameter("deptno");
            ps.setString(1, deptno);
            rs = ps.executeQuery();
            Department department = null;
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                department = new Department(deptno, dname, loc);
            }
            req.setAttribute("dept", department);
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    private void doList(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "select deptno, dname, loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Department> depts = new ArrayList<Department>();
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Department department = new Department(deptno, dname, loc);
                depts.add(department);
            }
            req.setAttribute("depts", depts);
            req.getRequestDispatcher("/list.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}