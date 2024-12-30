package com.fit.nlu.DHHCeramic.controller.admin.discount;

import com.fit.nlu.DHHCeramic.model.Blog;
import com.fit.nlu.DHHCeramic.model.Discount;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.DiscountService;
import com.fit.nlu.DHHCeramic.services.impl.DiscountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(urlPatterns = {"/Admin/discount/edit"})
public class DisEditController extends HttpServlet {
    DiscountService discountService = new DiscountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Discount discount = discountService.get(Integer.parseInt(id));
        request.setAttribute("discount", discount);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            request.getRequestDispatcher("/view/admin/view/editDiscount.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Discount dis = new Discount();
        dis.setId(Integer.parseInt(request.getParameter("id")));
        dis.setName(request.getParameter("name"));
        dis.setDiscountType(request.getParameter("type"));
        dis.setDescription(request.getParameter("description"));
        dis.setDiscountPercent(Double.valueOf(request.getParameter("discountPercent")));
        dis.setDisId(Integer.parseInt(request.getParameter("disId")));
        dis.setStartDate(java.sql.Date.valueOf(request.getParameter("startDate")));
        dis.setEndDate(java.sql.Date.valueOf(request.getParameter("endDate")));
        dis.setUpdateBy(request.getParameter("user"));
        dis.setUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));

        Discount oldProduct = discountService.get(dis.getId());
        discountService.edit(dis);
//        discountService.logProductEdit(user, oldProduct, product, request);
        response.sendRedirect(request.getContextPath() + "/Admin/discount/list");
    }
}
