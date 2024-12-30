package com.fit.nlu.DHHCeramic.controller.client;

import com.fit.nlu.DHHCeramic.model.Discount;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.DiscountService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.DiscountServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static java.lang.System.*;

@WebServlet(urlPatterns = "/apply-discount")
public class DiscountController extends HttpServlet {
    private final DiscountService discountService = new DiscountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String discountCode = req.getParameter("discount");
        Map<Integer, OrderDetails> cart = (Map<Integer, OrderDetails>) session.getAttribute("cart");
        System.out.println(cart);
        Discount discount = discountService.get(discountCode);
        System.out.println(discount.getDisId());
        System.out.println(discount.getDiscountType());
        long feeShip = 50000;
        if (discount != null) {
            long totalDiscount = 0;
            switch (discount.getDiscountType()) {
                case "PRODUCT":
                    totalDiscount = (long)applyProductDiscount(cart, discount);
                    break;
                case "CATEGORY":
                    totalDiscount = (long) applyCategoryDiscount(cart, discount);
                    break;
                case "ALL":
                    totalDiscount =  (long) applyAllDiscount(cart, discount);
                    break;
            }
            req.setAttribute("feeShip", feeShip);
            req.setAttribute("discountTotal", totalDiscount);
            req.setAttribute("discountApplied", true);
        } else {
            req.setAttribute("discountApplied", false);
            req.setAttribute("discountError", "Mã giảm giá không tồn tại");
        }

        req.getRequestDispatcher("/member/cart").forward(req, resp);
    }

    private double applyProductDiscount(Map<Integer, OrderDetails> cart, Discount discount) {
        double discountAmount = 0.0;
        for (OrderDetails item : cart.values()) {
            if (item.getProduct().getId() == discount.getDisId()) {
                if (discount.getDiscountPercent() <= 1) {
                    discountAmount += (item.getProduct().getPrice() * (discount.getDiscountPercent()))  * item.getQuantity();
                } else {
                    discountAmount += (discount.getDiscountPercent()) * item.getQuantity();
                }
                break;
            }
        }
        System.out.println("Discount amount for product discount: " + discountAmount);
        return discountAmount;
    }

    private double applyCategoryDiscount(Map<Integer, OrderDetails> cart, Discount discount) {
        double discountAmount = 0.0;
        for (OrderDetails item : cart.values()) {
            out.println("Cate: "+item.getProduct().getCategory().getId());
            if (item.getProduct().getCategory().getId() == discount.getDisId()) {
                if (discount.getDiscountPercent() <= 1) {
                    discountAmount += (item.getProduct().getPrice() * (discount.getDiscountPercent()));
                } else {
                    discountAmount += discount.getDiscountPercent() ;
                }
            }
        }
        System.out.println("Discount amount for category discount: " + discountAmount);
        return discountAmount;
    }

    private double applyAllDiscount(Map<Integer, OrderDetails> cart, Discount discount) {
        double discountAmount = 0.0;
        for (OrderDetails item : cart.values()) {
            if (discount.getDiscountPercent() <= 1) {
                discountAmount += (item.getProduct().getPrice() * (discount.getDiscountPercent())) * item.getQuantity();
            } else {
                discountAmount += discount.getDiscountPercent() * item.getQuantity();
            }
        }
        System.out.println("Discount amount for all products discount: " + discountAmount);
        return discountAmount;
    }
}