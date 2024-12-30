package com.fit.nlu.DHHCeramic.controller.client.cart;

import com.fit.nlu.DHHCeramic.model.OrderDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = {"/cart/remove"}) // ?pId=?123
public class CartItemRemove extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
        String pId = req.getParameter("pId");
        if (obj != null) {
            Map<Integer, OrderDetails> map = (Map<Integer, OrderDetails>) obj; // ep ve kieu cua no
            // Xoa san pham trong map
            map.remove(Integer.parseInt(pId));

            // Cap nhat lai Session
            httpSession.setAttribute("cart", map);
        }
        resp.sendRedirect(req.getContextPath() + "/member/cart");
    }
}

