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
import java.util.HashSet;
@WebServlet(urlPatterns = {"/welcome"})
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        String username = null;
        String password = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")){
                    username = cookie.getValue();
                }
                else if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
        else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        if (username != null && password != null){
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
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
                response.sendRedirect(request.getContextPath()+"/dept/list");
            }
            else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        }
        else {
            System.out.println(request.getContextPath()+"/index.jsp");

//            response.sendRedirect("/servlet15/index.jsp");
        }

    }
}
