package oa.web.action;

import oa.bean.User;
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
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("username".equals(name)){
                    username = cookie.getValue();
                }else if("password".equals(name)){
                    password = cookie.getValue();
                }
            }
        }

        // 要在这里使用username和password变量
        if(username != null && password != null){
            // 验证用户名和密码是否正确
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            boolean success = false;
            try {
                conn = DBUtils.getConnection();
                String sql = "select * from t_user where username = ? and password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    // 登录成功
                    success = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    DBUtils.close(conn, ps, rs);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (success) {
                // 获取session
                HttpSession session = request.getSession();
                //session.setAttribute("username", username);

                User user = new User(username, password);
                session.setAttribute("user", user);

                // 正确，表示登录成功
                response.sendRedirect(request.getContextPath() + "/dept/list");
            }else{
                // 错误，表示登录失败
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }else{
            // 跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }


    }
}
