package com.fit.nlu.DHHCeramic.controller.admin.product;

import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.ProductLogServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/product/edit"})
public class ProductEditController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    ProductLogServiceImpl logService = new ProductLogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productService.get(Integer.parseInt(id));
        List<Category> categories = categoryService.getAll();

        request.setAttribute("categories", categories);

        request.setAttribute("product", product);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/editProduct.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");//
        String price = request.getParameter("price");//
        String salePrice = request.getParameter("saleId");//
        String manufacturer = request.getParameter("manufacture");//
        String stock = request.getParameter("stock");//
        String des = request.getParameter("des");//
        int category = categoryService.get(request.getParameter("category")).getId();
        String image = request.getParameter("avatar");//

        int status = Integer.parseInt(request.getParameter("status"));//
        String size = request.getParameter("size");
        String user = request.getParameter("user");//
        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setName(name);
        product.setPrice(Long.parseLong(price));
        product.setSaleId(Long.parseLong(salePrice));
        product.setManufacture(manufacturer);

        product.setStock(Integer.parseInt(stock));
        product.setDes(des);
        product.setCategory(categoryService.get(category));
        product.setImage(image);
        product.setStatus(status);
        product.setSize(size);
        product.setUpdatedBy(user);
        product.setUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));
        Product oldProduct = productService.get(product.getId());
        productService.edit(product);
        logService.logProductEdit(user, oldProduct, product, request);
        response.sendRedirect(request.getContextPath() + "/Admin/product/list");
    }
}

