package com.fit.nlu.DHHCeramic.controller.client.authencation;


import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;
import com.fit.nlu.DHHCeramic.tools.SendEmail;
import com.fit.nlu.DHHCeramic.util.Constant;
import com.fit.nlu.DHHCeramic.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "VerifyController", value = "/verify")
public class VerifyController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("authcode");

        String code = request.getParameter("code");
        if (code.equals(user.getCode())) {
            userService.register(user.getEmail(), user.getUsername(), SecurityUtils.hash(user.getPassword()));
            SendEmail.sendMail(user.getEmail(), "DHH-Welcome", "Welcome to DHH. Your account has been verified!");
//            response.sendRedirect(request.getContextPath() + "/login");
            String alert = "Bạn đã xác nhận thành công";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher(Constant.Path.LOGIN).forward(request, response);
        } else {
            SendEmail.sendMail(user.getEmail(), "DHH-Welcome", "Welcome to DHH. Failed to verify your account!");
            String alert = "Xác nhận không thành công, hãy xác nhận email";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher(Constant.Path.REGISTER).forward(request, response);
        }
    }
}
