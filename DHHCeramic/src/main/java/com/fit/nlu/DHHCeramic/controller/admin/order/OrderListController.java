package com.fit.nlu.DHHCeramic.controller.admin.order;



import com.fit.nlu.DHHCeramic.model.Order;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.services.OrderDetailsService;
import com.fit.nlu.DHHCeramic.services.OrderService;
import com.fit.nlu.DHHCeramic.services.impl.OrderDetailsServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/order/list"})
public class OrderListController extends HttpServlet {
    OrderDetailsService cartItemService = new OrderDetailsServiceImpl();
    OrderService cartService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDetails> listCartItem = cartItemService.getAll();
        req.setAttribute("listCartItem", listCartItem);
        List<Order> listCart = cartService.getAll();
        req.setAttribute("listCart", listCart);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/table-data-oder.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

