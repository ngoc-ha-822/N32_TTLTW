package com.fit.nlu.DHHCeramic.controller.client;

import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.services.OrderDetailsService;
import com.fit.nlu.DHHCeramic.services.impl.OrderDetailsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RemoveOrderedController", value = "/myAccount/remove-ordered-item")
public class RemoveOrderedController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String user_id = request.getParameter("user_id");
        OrderDetailsService cartItemService = new OrderDetailsServiceImpl();
        List<OrderDetails> cartItems = cartItemService.getByUserID(Integer.parseInt(user_id));
        cartItemService.delete(id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        for (OrderDetails cartItem : cartItems) {
            out.println(" <div class=\"row\">\n" +
                    "                                        <div class=\"col-md-2 product-img\">\n" +
                    "                                            <img src=\"" + cartItem.getProduct().getImage() + "\">\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"col-md-10 product-info\">\n" +
                    "                                            <h4>" + cartItem.getProduct().getName() + "</h4>\n" +
                    "                                            <div class=\"quantityAndRemove\">\n" +
                    "                                                <p>x" + cartItem.getQuantity() + "</p>\n" +
                    "                                                <button class=\"btn-remove removeInAccount\" type=\"button\"\n" +
                    "                                                        onclick=\"removeCartItem(" + cartItem.getProduct().getId() + ")\">\n" +
                    "                                                    <i class=\"fas fa-trash-alt\"></i>Huỷ Đơn\n" +
                    "                                                </button>\n" +
                    "                                            </div>\n" +
                    "                                            <span class=\"base-price\">" + cartItem.getProduct().getPrice() + "đ</span>\n" +
                    "                                            <span class=\"discount\">" + cartItem.getProduct().getSaleId() + "đ</span>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <hr>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
