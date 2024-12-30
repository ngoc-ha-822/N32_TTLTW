package com.fit.nlu.DHHCeramic.controller.admin.category;


import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.CategoryLogServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/Admin/cate/edit"})
public class CateEditController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();
    CategoryLogServiceImpl logService = new CategoryLogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Category category = cateService.get(Integer.parseInt(id));

        request.setAttribute("category", category);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/editCategory.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Category category = new Category();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        category.setStatus(Integer.parseInt(request.getParameter("status")));
        category.setUpdatedBy(request.getParameter("user"));
        category.setUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));
        String user = request.getParameter("user");
        Category oldCate = cateService.get(category.getId());
        cateService.edit(category);
        logService.logCategoryEdit(user, oldCate, category, request);
        System.out.println("Status value: " + category);
        response.sendRedirect(request.getContextPath() + "/Admin/cate/list");

    }
}
