package com.fit.nlu.DHHCeramic.controller.admin.log;

import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/Admin/log/deleteSelected"})
public class LogDeleteSelectedController extends HttpServlet {
    private final LogDao logDao = new LogDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String requestData = request.getReader().lines().collect(Collectors.joining());
        String[] selectedIds = mapper.readValue(requestData, String[].class);

        if (selectedIds != null && selectedIds.length > 0) {
            for (String id : selectedIds) {
                logDao.delete(Integer.parseInt(id));
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{ \"message\": \"Xóa log đã chọn thành công\" }");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không có log được chọn để xóa");
        }
    }
}
