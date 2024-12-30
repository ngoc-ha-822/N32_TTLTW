package com.fit.nlu.DHHCeramic.controller.admin.log;

import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Admin/log/delete"})
public class LogDeleteController extends HttpServlet {
    LogDao logDao = new LogDaoImpl();
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        logDao.delete(Integer.parseInt(id));
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            // Trả về phản hồi JSON thông báo rằng xóa đã thành công
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{ \"message\": \"Xóa người dùng thành công\" }");
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }
}
