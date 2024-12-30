package com.fit.nlu.DHHCeramic.controller.admin.category;

import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.CategoryLogServiceImpl;
import com.fit.nlu.DHHCeramic.util.SecurityUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/Admin/cate/add"})
public class CateAddController extends HttpServlet {
    private static final long SerialVersionUID = 1L;

    CategoryService cateService = new CategoryServiceImpl();
    CategoryLogServiceImpl logService = new CategoryLogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eString = request.getParameter("e");
        if (eString != null) {
            if (eString.equals("1")) {
                request.setAttribute("errMsg", "Category da ton tai!!!");
            }
        }
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/addCategory.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Category cate = new Category();
        cate.setName(request.getParameter("name"));
        cate.setStatus(Integer.parseInt(request.getParameter("status")));
        cate.setCreatedBy(request.getParameter("user"));
        String user = request.getParameter("user");
        cate.setCreatedDate(Date.valueOf(LocalDate.now()));
        logService.logCategoryAdd(user, cate, request);
        cateService.insert(cate);
        response.sendRedirect(request.getContextPath() + "/Admin/cate/list");

    }
}
