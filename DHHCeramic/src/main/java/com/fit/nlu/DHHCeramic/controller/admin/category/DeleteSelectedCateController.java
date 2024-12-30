package com.fit.nlu.DHHCeramic.controller.admin.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.CategoryLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/Admin/cate/deleteSelected")
public class DeleteSelectedCateController extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private CategoryLogServiceImpl logService = new CategoryLogServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String requestData = request.getReader().lines().collect(Collectors.joining());
        String[] selectedIds = mapper.readValue(requestData, String[].class);

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            String username = (String) session.getAttribute("username");
            if (selectedIds != null && selectedIds.length > 0) {
                for (String id : selectedIds) {
                    int categoryId = Integer.parseInt(id);
                    Category deletedCate = categoryService.get(categoryId);
                    categoryService.delete(categoryId);
                    System.out.println(deletedCate);
                    System.out.println(username);
                    logService.logCategoryDelete(username, deletedCate, request);
                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{ \"message\": \"Xóa cate đã chọn thành công\" }");
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không có cate được chọn để xóa");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bạn cần đăng nhập để thực hiện thao tác này");
        }
    }
}
