package com.fit.nlu.DHHCeramic.controller.admin.user;


import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.LogService;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.UserLogServiceImpl;
import com.fit.nlu.DHHCeramic.util.SecurityUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/Admin/user/edit"})
public class UserEditController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    UserLogServiceImpl logService = new UserLogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.get(id);
        request.setAttribute("user", user);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/editUser.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(SecurityUtils.hash(request.getParameter("password")));
        user.setFullname(request.getParameter("fullname"));
        user.setAvatar(request.getParameter("avatar"));
        user.setAddress(request.getParameter("address"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
        user.setStatus(Integer.parseInt(request.getParameter("status")));
        user.setUpdatedBy(request.getParameter("user"));
        user.setUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));
        String username = request.getParameter("user");
        User userOld = userService.get(user.getId());
        userService.edit(user);
        logService.logUserEdit(username,userOld,user,request);
        response.sendRedirect(request.getContextPath() + "/Admin/user/list");
    }
}

