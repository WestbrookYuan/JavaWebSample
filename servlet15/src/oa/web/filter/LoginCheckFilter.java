package oa.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        System.out.println(servletPath.equals("/index.jsp"));

        if (servletPath.equals("/index.jsp")
                || servletPath.equals("/welcome")
                || servletPath.equals("/user/login")
                || servletPath.equals("/user/logout")
                || (session != null && session.getAttribute("username") != null)) {
            chain.doFilter(request, response);
        } else {
            System.out.println(request.getContextPath() + "/index.jsp");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
