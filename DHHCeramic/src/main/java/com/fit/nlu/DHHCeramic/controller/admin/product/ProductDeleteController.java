package com.fit.nlu.DHHCeramic.controller.admin.product;


import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.CategoryLogServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.ProductLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Admin/product/delete"})
public class ProductDeleteController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    ProductLogServiceImpl logService = new ProductLogServiceImpl();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String user = request.getParameter("username");
        Product deleteProduct = productService.get(Integer.parseInt(id));
        logService.logProductDelete(user, deleteProduct, request);
        productService.delete(Integer.parseInt(id));
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{ \"message\": \"Xóa người dùng thành công\" }");
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }
}
