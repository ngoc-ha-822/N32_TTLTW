package com.fit.nlu.DHHCeramic.controller.admin.authencation;


import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;
import com.fit.nlu.DHHCeramic.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginController", value = "/AdminLogin")
public class AdminLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath() + "/AdminWaiting");
            return;
        }
        // Check cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/AdminWaiting");
                    return;
                }
            }
        }
        String alert = (String) request.getAttribute("alert");
        request.setAttribute("alert", alert);
        request.getRequestDispatcher("/view/admin/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        String password = request.getParameter("password");
        String alertMsg = "";

        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Vui lòng không để trống các ô bên dưới!";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/view/admin/view/login.jsp").forward(request, response);
            return;
        }

        UserService service = new UserServiceImpl();

        User user = service.login(username, password);


        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);
            response.sendRedirect(request.getContextPath() + "/AdminWaiting");

        } else {
            alertMsg = "Sai thông tin đăng nhập";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/view/admin/view/login.jsp").forward(request, response);
        }
    }
}

