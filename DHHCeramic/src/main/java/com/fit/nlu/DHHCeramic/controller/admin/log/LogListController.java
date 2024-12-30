package com.fit.nlu.DHHCeramic.controller.admin.log;

import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fit.nlu.DHHCeramic.model.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Admin/log/list"})

public class LogListController extends HttpServlet {
    LogDao logDao = new LogDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> logList = logDao.loadAllLog();
        request.setAttribute("logList", logList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/table-data-log.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


