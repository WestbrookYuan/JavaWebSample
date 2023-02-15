package oa.web.action;

import oa.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/user/login", "/user/logout"})
public class UserService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if (servletPath.equals("/user/login")){
            doLogin(request, response);
        } else if (servletPath.equals("/user/logout")) {
            doLogout(request, response);
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
            try {
                response.sendRedirect(request.getContextPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean loginSuccess = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()){
                loginSuccess = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                DBUtils.close(conn, ps, rs);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (loginSuccess){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            String isKeep = request.getParameter("keep");
            if(isKeep != null && isKeep.equals("keep")){
                Cookie nameCookie = new Cookie("username", username);
                Cookie pwdCookie = new Cookie("password", password);

                nameCookie.setMaxAge(60*60*24*10);
                pwdCookie.setMaxAge(60*60*24*10);
                nameCookie.setPath(request.getContextPath());
                pwdCookie.setPath(request.getContextPath());

                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
