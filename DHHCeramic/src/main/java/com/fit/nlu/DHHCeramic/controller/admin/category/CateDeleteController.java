package com.fit.nlu.DHHCeramic.controller.admin.category;

import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.CategoryLogServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.log.ProductLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Admin/cate/delete"})
public class CateDeleteController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();
    CategoryLogServiceImpl logService = new CategoryLogServiceImpl();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String user = request.getParameter("username"); // Lấy thông tin người dùng từ yêu cầu
        try {
            Category deletedCate = cateService.get(Integer.parseInt(id));

            // Ghi log cho thao tác xóa loại sản phẩm trước khi thực hiện xóa
            logService.logCategoryDelete(user, deletedCate, request);

            cateService.delete(Integer.parseInt(id));

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{ \"message\": \"Xóa danh mục thành công\" }");

        } catch (IllegalStateException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{ \"error\": \"" + e.getMessage() + "\" }");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }
}
