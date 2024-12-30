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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "OrderEditController", value = "/Admin/order/edit")
public class OrderEditController extends HttpServlet {
    OrderDetailsService cartItemService = new OrderDetailsServiceImpl();
    OrderService cartService = new OrderServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Order cart = cartService.get(id);
        request.setAttribute("id", id);
        request.setAttribute("cartItem", cart);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/editOrder.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String fullname = request.getParameter("fullname");
        String total = request.getParameter("total");
        String note = request.getParameter("note");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        Order oldCartItem = cartService.get(id);
        if (!isValidStatus(status, oldCartItem.getStatus())) {
            String alertMsg = "Trạng thái đơn hàng không hợp lệ";
            HttpSession session = request.getSession();
            session.setAttribute("error", alertMsg);
            response.sendRedirect(request.getContextPath() + "/Admin/order/edit?id=" + id);
            return;
        } else {
            Order cart = cartService.get(id);
            cart.getBuyer().setFullname(fullname);
            cart.setTotal(Long.valueOf(total));
            cart.setNote(note);
            cart.setAddress(address);
            cart.setPhoneNumber(phone);
            cart.setStatus(status);
            cartService.edit(cart);
            response.sendRedirect(request.getContextPath() + "/Admin/order/list");
        }
    }

    // Phương thức để kiểm tra tính hợp lệ của trạng thái đơn hàng mới
    private boolean isValidStatus(String newStatus, String currentStatus) {
        // Các trạng thái hợp lệ mà đơn hàng có thể chuyển sang từ trạng thái hiện tại
        switch (currentStatus) {
            case "Đang xử lý":
                return newStatus.equals("Đã xác nhận") || newStatus.equals("Đã hủy");
            case "Đã xác nhận":
                return newStatus.equals("Chuẩn bị hàng") || newStatus.equals("Đã hủy");
            case "Chuẩn bị hàng":
                return newStatus.equals("Đã bàn giao cho đơn vị vận chuyển GHTK") || newStatus.equals("Đã hủy");
            case "Đã bàn giao cho đơn vị vận chuyển GHTK":
                return newStatus.equals("Đang giao hàng") || newStatus.equals("Đã hủy");
            case "Đang giao hàng":
                return newStatus.equals("Đã giao hàng") || newStatus.equals("Đã hoàn trả") || newStatus.equals("Đã hủy");
            case "Đã giao hàng":
                return newStatus.equals("Đã hoàn trả");
            case "Đã hoàn trả":
                return newStatus.equals("Đã hoàn trả");
            case "Đã hủy":
                return newStatus.equals("Đã hủy"); // Không thể chuyển từ trạng thái "Đã hủy" sang bất kỳ trạng thái nào khác
            default:
                return false;
        }
    }
}
