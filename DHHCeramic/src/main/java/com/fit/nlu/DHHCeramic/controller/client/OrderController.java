package com.fit.nlu.DHHCeramic.controller.client;


import com.fit.nlu.DHHCeramic.model.Order;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.OrderDetailsService;
import com.fit.nlu.DHHCeramic.services.OrderService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.OrderServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.OrderDetailsServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;
import com.fit.nlu.DHHCeramic.tools.SendEmail;
import com.fit.nlu.DHHCeramic.util.RandomUUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    OrderService cartService = new OrderServiceImpl();
    ProductService productService = new ProductServiceImpl();
    OrderDetailsService cartItemService = new OrderDetailsServiceImpl();
    long time = System.currentTimeMillis();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        User buyer = (User) obj;
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String note = req.getParameter("note");
        String status = req.getParameter("status");
        Long total = Long.valueOf((req.getParameter("total")));
        Order cart = new Order();
        cart.setBuyer(buyer);
        cart.setBuyDate(new java.sql.Date(time));
        cart.setAddress(address);
        cart.setPhoneNumber(phone);
        cart.setNote(note);
        cart.setTotal(Long.valueOf(total));
        cart.setId(RandomUUID.getRandomID());
        cart.setStatus(status);
        cartService.insert(cart);
        Object objCart = session.getAttribute("cart");
//        if (objCart != null) {
        // ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
        Map<Integer, OrderDetails> map = (Map<Integer, OrderDetails>) objCart;

        for (OrderDetails cartItem : map.values()) {
            cartItem.setOrder(cart);
            // công số sản phẩm bán
            Product p = productService.get(cartItem.getProduct().getId());
//            p.setSoldQuantity(productService.get(cartItem.getProduct().getId()).getSoldQuantity() + cartItem.getQuantity());
            productService.edit(p);
            cartItem.setId(RandomUUID.getRandomID());
            SendEmail.sendMail(cart.getBuyer().getEmail(), "DHH Ceramic", "Payment success. We will contact you soon ! ");
            cartItemService.insert(cartItem);

//            }
        }
        session.removeAttribute("cart");
        resp.sendRedirect(req.getContextPath() + "/welcome");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
