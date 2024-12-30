package com.fit.nlu.DHHCeramic.controller.client.cart;

import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = {"/cart/add"}) // ?pId=123
public class CartAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pId = req.getParameter("pId");
        String quantity = req.getParameter("quantity");
        String size = req.getParameter("size");
//        String status = req.getParameter("status");
        Product product = productService.get(Integer.parseInt(pId));
        OrderDetails cartItem = new OrderDetails();
        cartItem.setQuantity(Integer.parseInt(quantity));
        cartItem.setUnitPrice(product.getPrice());
        cartItem.setProduct(product);
        cartItem.setSize(size);
        HttpSession httpSession = req.getSession();
        Object obj = httpSession.getAttribute("cart");
        Map<Integer, OrderDetails> map;
        if (obj == null) {
            map = new HashMap<Integer, OrderDetails>();
            map.put(cartItem.getProduct().getId(), cartItem);
        } else {
            map = (Map<Integer, OrderDetails>) obj;

            OrderDetails existedCartItem = map.get(Integer.valueOf(pId));

            if (existedCartItem == null) {
                map.put(product.getId(), cartItem);
            } else {
                existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
            }

        }
        httpSession.setAttribute("cart", map);
        resp.setCharacterEncoding("UTF-8");
        int count = 0;
        PrintWriter out = resp.getWriter();
        out.println( "   <ul class=\"list-inline shop-badge badge-lists badge-icons pull-right header__nav-cart \">\n" +
                "                        <li class=\"header__nav-item header__nav-item-has-product\">\n" +
                "                            <a href=\"http://localhost:8080/DHHCeramic/member/cart\" class=\"header__nav-item-link\">\n" +
                "                                <i class=\"fas fa-shopping-cart\">" + "</i>\n");
//        "                            </a>\n");
        for (Map.Entry<Integer, OrderDetails> entry : map.entrySet()) {
            count++;
        }
        out.println( "<span>" + count + "</span></a>\n" +

                "\n" +
                "                            <c:choose>\n" +
                "                                <c:when test=\"${sessionScope.account.avatar==null}\">\n" +
                "                                    <div class=\"header__no-cart\">\n" +
                "                                        <img src=\"${url}/images/home/no-cart.png\" class=\"img__no-cart\">\n" +
                "                                        <div class=\"no__cart-text\">\n" +
                "                                            <span>Đăng nhập để xem giỏ hàng</span>\n" +
                "                                        </div>\n" +
                "\n" +
                "                                    </div>\n" +
                "                                </c:when>\n" +
                "                                <c:otherwise>\n" +
                "                                    <div class=\"header__has-cart\">\n" +
                "                                        <ul class=\"list-unstyled badge-open mCustomScrollbar header__cart-list\"\n" +
                "                                            data-mcs-theme=\"minimal-dark\" id=\"contentCart\">\n");
        for (Map.Entry<Integer, OrderDetails> entry : map.entrySet()) {
            out.println(

                    "                                                <li class=\"header__cart-item header__cart-view\">\n" +
                            "                                                   <a class=\"header__cart-link\"\n" +
                            "                                                                                href=\"http://localhost:8080/DHHCeramic/product/detail?id=" + entry.getValue().getProduct().getId() + "\">\n" +
                            "                                                    <img src=\"" + entry.getValue().getProduct().getImage() + "\" alt=\"\" width=\"10\"\n" +
                            "                                                         height=\"20\" class=\"header__cart-img\">\n" +
                            "                                                    <div class=\"overflow-h header__cart-name\">\n" +
                            "                                                        <p><b>" + entry.getValue().getProduct().getName() + "</b></p>\n" +
                            "                                                        <p>" + entry.getValue().getQuantity() + "\n" +
                            "                                                            * " + entry.getValue().getProduct().getSaleId() + "đ </p>\n" +
                            "                                                    </div>\n" +
                            "                                                    <a\n" +
                            "                                                            href=\"http://localhost:8080/DHHCeramic/cart/remove?pId=" + entry.getValue().getProduct().getId() + " \">\n" +
                            "                                                        <button\n" +
                            "                                                                type=\"button\" class=\"close\">×\n" +
                            "                                                        </button>\n" +
                            "                                                    </a>\n" +
                            "\n" +
                            "                                                </a>\n" +
                            "                                                </li>\n");
        }
        out.println(
                "                                        </ul>\n" +
                        "                                        <footer class=\"header__cart-footer\">\n" +
                        "                                            <a href=\"${pageContext.request.contextPath}/member/cart\"\n" +
                        "                                               class=\"header__cart-footer-btn\">Xem tất cả</a>\n" +
                        "                                        </footer>\n" +
                        "                                    </div>\n" +
                        "                                </c:otherwise>\n" +
                        "                            </c:choose>\n" +
                        "\n" +
                        "\n" +
                        "                        </li>\n" +
                        "                    </ul>");

    }
}
