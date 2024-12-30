package com.fit.nlu.DHHCeramic.controller.admin.category;

import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/cate/list"})
public class CateListController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> cateList = cateService.getAll();
        request.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/table-data-category.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
