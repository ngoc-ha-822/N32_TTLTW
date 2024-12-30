package com.fit.nlu.DHHCeramic.controller.client;

import com.fit.nlu.DHHCeramic.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ChangeAddressController", value = "/order/change-address")
public class ChangeAddressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String alert = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        user.setAddress(request.getParameter("newAddress"));
        Pattern pattern = Pattern.compile("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$");
        Matcher match = pattern.matcher(request.getParameter("newPhone"));
//returns a boolean value
        boolean isValid = false;
        isValid = (match.find() && match.group().equals(request.getParameter("newPhone")));
        if (isValid) {
            user.setPhoneNumber(request.getParameter("newPhone"));
        } else {
            user.setPhoneNumber("");
            alert = "Số điện thoại không hợp lệ!";
        }
        user.setPhoneNumber(request.getParameter("newPhone"));
        user.setFullname(request.getParameter("newName"));
        session.setAttribute("account", user);
        alert = "Thông tin của bạn đã được thay đổi!";
        String encodedAlert = URLEncoder.encode(alert, "UTF-8");
        response.sendRedirect(request.getContextPath() + "/member/cart?alert=" + encodedAlert);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
