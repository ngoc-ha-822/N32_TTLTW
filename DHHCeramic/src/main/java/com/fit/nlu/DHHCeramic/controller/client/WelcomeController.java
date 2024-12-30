package com.fit.nlu.DHHCeramic.controller.client;


import com.fit.nlu.DHHCeramic.model.Blog;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.services.BlogService;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.BlogServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/welcome")

public class WelcomeController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();
    BlogService blogService = new BlogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//                1: danh sách loại gạch men
        String alert = request.getParameter("alert");
        List<Category> listCate = cateService.getAll();
        request.setAttribute("pCate", listCate);

        List<Blog> listBlogs = blogService.getAll();
        request.setAttribute("listBlogs", listBlogs);
        request.getRequestDispatcher("/view/client/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
