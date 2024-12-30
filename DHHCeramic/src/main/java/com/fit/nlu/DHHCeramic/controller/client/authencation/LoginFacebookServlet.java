package com.fit.nlu.DHHCeramic.controller.client.authencation;


import com.fit.nlu.DHHCeramic.util.Constant;
import com.fit.nlu.DHHCeramic.util.RestFB;
import com.restfb.types.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;

@WebServlet(name = "LoginFacebookServlet", value = "/login-facebook")
public class LoginFacebookServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher(Constant.Path.LOGIN);
            dis.forward(request, response);
        } else {
            String accessToken = RestFB.getToken(code);
            User user = RestFB.getUserInfo(accessToken);

            com.fit.nlu.DHHCeramic.model.User u = new com.fit.nlu.DHHCeramic.model.User();
            u.setUsername(user.getName());
            u.setEmail(user.getEmail()); // Thêm thông tin email
            u.setFullname(user.getName());
            u.setFacebook(user.getName());
            u.setAvatar(user.getPicture().getUrl());
            u.setPassword("");
            u.setRoleId(2);
            u.setCreatedDate(new java.util.Date());
            HttpSession session = request.getSession(true);
            session.setAttribute("account", u);
            userService.insert(u);
            response.sendRedirect(request.getContextPath() + "/waiting");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


