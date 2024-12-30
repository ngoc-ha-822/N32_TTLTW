package com.fit.nlu.DHHCeramic.controller.client;


import com.fit.nlu.DHHCeramic.model.Discount;
import com.fit.nlu.DHHCeramic.model.Order;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.DiscountService;
import com.fit.nlu.DHHCeramic.services.OrderDetailsService;
import com.fit.nlu.DHHCeramic.services.OrderService;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.DiscountServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.OrderDetailsServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.OrderServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = {"/member/myAccount"})
public class MyAccountController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    OrderDetailsService cartItemService = new OrderDetailsServiceImpl();
    OrderService cartService = new OrderServiceImpl();

    DiscountService discountService = new DiscountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> listCart = new ArrayList<Order>();
        String id = request.getParameter("id");
        System.out.println(id);
        User user = userService.get(Integer.parseInt(id));
        listCart = cartService.getByUserId(Integer.parseInt(id));
        List<Discount> listDiscount = discountService.getAll();
        List<OrderDetails> listCartItem = cartItemService.getByUserID(Integer.parseInt(id));
        String alert = request.getParameter("alert");
        request.setAttribute("alert", alert);
        request.setAttribute("listCart", listCart);
        request.setAttribute("listCartItem", listCartItem);
        request.setAttribute("listDiscount", listDiscount);
        System.out.println("List discount: " + listDiscount);
        System.out.println("List of Cart Items: " + listCartItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/view/account.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String alert = "";
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String facebook = request.getParameter("facebook");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String avatar = request.getParameter("avatar");
        int role = Integer.parseInt(request.getParameter("role"));
        System.out.println(id + name + username + facebook + email + phone + address + avatar);
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setFullname(name);
        user.setUsername(username);
        user.setFacebook(facebook);
        user.setEmail(email);
        user.setPassword(password);
        user.setAvatar(avatar);
        user.setAddress(address);
        Pattern pattern = Pattern.compile("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$");
        Matcher match = pattern.matcher(phone);
//returns a boolean value
        boolean isValid = false;
        isValid = (match.find() && match.group().equals(phone));
        if (isValid) {
            user.setPhoneNumber(phone);
        } else {
            user.setPhoneNumber("");
            alert = "Số điện thoại không hợp lệ!";
        }
        user.setRoleId(role);
        userService.edit(user);
        alert = "Success!";
        User u = userService.get(Integer.parseInt(id));
        HttpSession session = request.getSession(true);
        session.setAttribute("account", u);
        response.sendRedirect(request.getContextPath() + "/member/myAccount?id=" + id + "&alert=" + alert);

    }
}
