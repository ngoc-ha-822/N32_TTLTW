package com.fit.nlu.DHHCeramic.controller.client.cart;

import com.fit.nlu.DHHCeramic.dao.ProductDao;
import com.fit.nlu.DHHCeramic.dao.impl.ProductDaoImpl;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.model.Product;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "CartUpdateController", value = "/cart/update")
public class CartUpdateController extends HttpServlet {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String actionParam = request.getParameter("action");

        if ("update-cart".equals(actionParam)) {
            doPostUpdateCart(request, response);
        }
    }

    private void doPostUpdateCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id_item"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String size = request.getParameter("size");

        // Lấy giá sản phẩm từ cơ sở dữ liệu hoặc từ nơi lưu trữ khác
        OrderDetails cartItem = new OrderDetails();
        Product product = productDao.get(id);
        // Tính toán giá mới của sản phẩm
        double newPrice = product.getPrice() * quantity;
        cartItem.setQuantity(quantity);
        cartItem.setUnitPrice(product.getPrice());
        cartItem.setProduct(product);
        cartItem.setSize(size);
        HttpSession session = request.getSession();
        HashMap<Integer, OrderDetails> cart = (HashMap<Integer, OrderDetails>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(id)) {
            if (quantity <= 0) {
                cart.remove(id);
            } else {
                cart.put(id, cartItem);
            }
            session.setAttribute("cart", cart);
        }
        double newSumPrice = 0;
        // Duyệt qua tất cả các mục trong giỏ hàng và tính toán tổng giá mới
        for (OrderDetails orderDetails : cart.values()) {
            newSumPrice += orderDetails.getQuantity() * orderDetails.getProduct().getPrice();
        }
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("new_price", newPrice); // Thêm giá mới vào dữ liệu trả về
        json.put("newSumPrice", newSumPrice);
        PrintWriter out = response.getWriter();
        out.println(json.toString());
        out.close();
    }
}
