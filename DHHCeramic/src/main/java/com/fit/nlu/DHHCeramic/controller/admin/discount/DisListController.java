package com.fit.nlu.DHHCeramic.controller.admin.discount;

import com.fit.nlu.DHHCeramic.model.Discount;
import com.fit.nlu.DHHCeramic.services.DiscountService;
import com.fit.nlu.DHHCeramic.services.impl.DiscountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/discount/list"})
public class DisListController extends HttpServlet {
    DiscountService discountService = new DiscountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discount> listDiscount = discountService.getAll();
        req.setAttribute("listDiscount", listDiscount);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/table-data-discount.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
