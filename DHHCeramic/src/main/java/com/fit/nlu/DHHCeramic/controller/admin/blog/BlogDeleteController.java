package com.fit.nlu.DHHCeramic.controller.admin.blog;

import com.fit.nlu.DHHCeramic.services.BlogService;
import com.fit.nlu.DHHCeramic.services.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Admin/blog/delete"})
public class BlogDeleteController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            blogService.delete(Integer.parseInt(id));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{ \"message\": \"Xóa blog thành công\" }");
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response); // Chuyển tiếp yêu cầu GET thành DELETE để xử lý
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response); // Chuyển tiếp yêu cầu POST thành DELETE để xử lý
    }
}
