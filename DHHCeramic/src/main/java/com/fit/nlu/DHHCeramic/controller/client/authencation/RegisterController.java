package com.fit.nlu.DHHCeramic.controller.client.authencation;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;
import com.fit.nlu.DHHCeramic.tools.SendEmail;
import com.fit.nlu.DHHCeramic.util.Constant;
import com.fit.nlu.DHHCeramic.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }
        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }

        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService service = new UserServiceImpl();
        String alertMsg = "";
        if (email == "" || password == "" || username == "") {
            alertMsg = "Vui lòng không để trống các ô!";
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }
        if (service.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }
        if (service.checkExistUsername(username)) {
            alertMsg = "Tên người dùng đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }
        if (password.length() < 8 || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            alertMsg = "Mật khẩu phải chứa ít nhất 8 ký tự, bao gồm ít nhất một ký tự chữ cái viết thường, một ký tự chữ cái viết hoa, một số và một ký tự đặc biệt!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }

//        boolean isSuccess = service.register(username, SecurityUtils.hash(password), email);
//
//        if (isSuccess) {
        SendEmail sm = new SendEmail();
        String code = sm.getRandom();
        System.out.println("Code from getRandom(): " + code); // In giá trị ra console
        User user = new User(email, username, code, password);
        SendEmail.sendMail(email, "DHH-Email of verification", "Welcome to DHH Ceramic. Here is your verification code: " + user.getCode() + " .Thanks !");
        HttpSession session = req.getSession();
        session.setAttribute("authcode", user);
        resp.sendRedirect(req.getContextPath() + "/redirect");
//        } else {
//            alertMsg = "System error!";
//            req.setAttribute("alert", alertMsg);
//            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
//
//        }
    }
}