package com.fit.nlu.DHHCeramic.controller.client;

import com.fit.nlu.DHHCeramic.dao.OrderDao;
import com.fit.nlu.DHHCeramic.dao.impl.OrderDaoImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cancelOrder")
public class CancelOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String reason = request.getParameter("reason");

        // Assume you have an OrderDAO to handle database operations
        OrderDaoImpl orderDAO = new OrderDaoImpl();

        boolean isCancelled = orderDAO.cancelOrder(orderId, reason);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if (isCancelled) {
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }
}