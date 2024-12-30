package com.fit.nlu.DHHCeramic.controller.client.authencation;


import com.fit.nlu.DHHCeramic.controller.client.VerifyCaptcha;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.log.LoginLogServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "Login", value = "/login")
public class LoginController extends HttpServlet {
    private LoginLogServiceImpl loginLogService = new LoginLogServiceImpl();
    private Integer failedLoginCount = 0; // Khởi tạo failedLoginCount ở đây

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }
        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/waiting");
                    return;
                }
            }
        }
        String alert = req.getParameter("alert");
        req.setAttribute("alert", alert);
        req.getRequestDispatcher("view/client/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String alertMsg = "";

        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Vui lòng không để trống các ô bên dưới!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
            return;
        }

        // Lấy địa chỉ IP của người dùng
        String ipAddress = req.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("HTTP_X_FORWARDED");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("HTTP_FORWARDED");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getRemoteAddr();
        }

        // Thêm xử lý cho địa chỉ IP là IPv6 loopback address
        if (ipAddress.equals("0:0:0:0:0:0:0:1") || ipAddress.equals("::1")) {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        }
//        // Kiểm tra reCAPTCHA
//        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
//        boolean verify = VerifyCaptcha.verify(gRecaptchaResponse);
        boolean verify = true;
        // Kiểm tra đăng nhập
        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if (user != null && verify) {
            if (user.getStatus() == 0) {
                // Tài khoản bị khóa
                alertMsg = "Tài khoản của bạn đã bị khóa";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
            } else {
                // Đăng nhập thành công
                HttpSession session = req.getSession(true);
                session.setAttribute("account", user);
                resp.sendRedirect(req.getContextPath() + "/waiting");
            }
        } else {
            // Đăng nhập không thành công
            loginLogService.logUserLoginFailed(username, ipAddress, failedLoginCount, req);
            alertMsg = "Sai thông tin đăng nhập";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/client/view/login.jsp").forward(req, resp);
            failedLoginCount++;
        }
        System.out.println(ipAddress);
        System.out.println(failedLoginCount);
    }
//    private void saveRememberMe(HttpServletResponse response, String username) {
//        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
//        cookie.setMaxAge(30 * 60);
//        response.addCookie(cookie);
//    }
}



