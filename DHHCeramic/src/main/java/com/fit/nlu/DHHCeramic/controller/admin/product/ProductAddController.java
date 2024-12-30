package com.fit.nlu.DHHCeramic.controller.admin.product;

import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.LogService;
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

@WebServlet(urlPatterns = {"/Admin/product/add"})
public class ProductAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    ProductLogServiceImpl logService = new ProductLogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/form-add-san-pham.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String salePrice = request.getParameter("saleId");
        String manufacturer = request.getParameter("manufacture");
        String stock = request.getParameter("stock");
        String des = request.getParameter("des");
        int category = categoryService.get(request.getParameter("category")).getId();
        String image = request.getParameter("image");
        String size = request.getParameter("size");
        String user = request.getParameter("user");

        Product pro = new Product();
        pro.setName(name);//
        pro.setPrice(Long.parseLong(price));//
        pro.setSaleId(Long.parseLong(salePrice));//
        pro.setManufacture(manufacturer);//
        pro.setStock(Integer.parseInt(stock));//
        pro.setDes(des);//
        pro.setCategory(categoryService.get(category));//
        pro.setImage(image);//
        pro.setSize(size);
        pro.setCreatedBy(user);//
        pro.setCreatedDate(java.sql.Date.valueOf(LocalDate.now()));//
        productService.insert(pro);
        // Ghi log cho thao tác thêm sản phẩm
        logService.logProductAdd(user, pro, request);
        request.setAttribute("errorString", "Thêm sản phẩm thành công");
        response.sendRedirect(request.getContextPath() + "/Admin/product/list");
    }
}

