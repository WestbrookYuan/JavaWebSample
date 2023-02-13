package oa.web.action;

import oa.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(urlPatterns = {"/dept/list", "/dept/delete", "/dept/add", "/dept/edit", "/dept/update", "/dept/detail"})
public class DeptService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        if (servletPath.equals("/dept/list")) {
            try {
                doList(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//        } else if (servletPath.equals("/dept/detail")) {
//            doDetail(req, resp);
//        } else if (servletPath.equals("/dept/delete")) {
//            doDel(req, resp);
//        } else if (servletPath.equals("/dept/add")) {
//            doAdd(req, resp);
//        } else if (servletPath.equals("/dept/edit")) {
//            doEdit(req, resp);
//        } else if (servletPath.equals("/dept/update")) {
//            doUpdate(req, resp);
//        }
    }

    }

    private void doList(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DBUtils.close(conn, ps, rs);
        }
    }

}