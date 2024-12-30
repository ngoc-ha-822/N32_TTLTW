package com.fit.nlu.DHHCeramic.controller.admin.productImport;

import com.fit.nlu.DHHCeramic.dao.impl.ProductImportDaoImpl;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.model.ProductImport;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Admin/productImport/edit"})
public class ProductImportEditController extends HttpServlet {
    ProductImportDaoImpl productImportDao = new ProductImportDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductImport productImport = productImportDao.get(Integer.parseInt(id));
        request.setAttribute("productImport", productImport);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            request.getRequestDispatcher("/view/admin/view/editProduct_Import.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Get the Product ID from the request
        int productId = Integer.parseInt(request.getParameter("productId"));

        // Fetch the Product object using the ProductService (Assuming you have a ProductService)
        ProductService productService = new ProductServiceImpl();
        Product product = productService.get(productId);

        // Create a ProductImport object and set its fields
        ProductImport productImport = new ProductImport();
        productImport.setProduct(product);
        productImport.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        productImport.setCreatedAt(java.sql.Timestamp.valueOf(request.getParameter("createdAt")));
        productImport.setPrice(Long.parseLong(request.getParameter("price")));
        productImport.setImportBatch(Integer.parseInt(request.getParameter("importBatch")));

        // Update the product import entry
        productImportDao.edit(productImport);

        // Redirect to the product import list page
        response.sendRedirect(request.getContextPath() + "/Admin/productImport/list");
    }
}
