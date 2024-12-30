package com.fit.nlu.DHHCeramic.controller.admin.order;

import com.fit.nlu.DHHCeramic.dao.OrderDetailsDao;
import com.fit.nlu.DHHCeramic.dao.impl.OrderDetailsDaoImpl;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/orderDetails/list"})
public class OrderDetailsListController extends HttpServlet {
    private OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("id");
        List<OrderDetails> orderDetailsList = orderDetailsDao.getByOrderId(orderId);
        request.setAttribute("listCartItem", orderDetailsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/orderDetailsList.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}