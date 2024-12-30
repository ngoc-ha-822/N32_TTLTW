package com.fit.nlu.DHHCeramic.controller.admin.log;

import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Log;
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
import java.net.InetAddress;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(urlPatterns = {"/Admin/log/edit"})
public class LogEditController extends HttpServlet {
    LogDao logDao = new LogDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Log log = logDao.getLogById(Integer.parseInt(id));
        request.setAttribute("log", log);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/editLog.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int logId = Integer.parseInt(request.getParameter("id"));
        int newLevel = Integer.parseInt(request.getParameter("level"));
        Log oldLog = logDao.getLogById(logId);

//        // Check if the log level is INFO and prevent lowering it
//        if (oldLog.getLevel() == Log.INFO && newLevel < Log.INFO) {
//            // Log level INFO is the lowest, cannot be decreased further
//            request.setAttribute("error", "Cannot lower log level from INFO.");
//            request.setAttribute("log", oldLog);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/editLog.jsp");
//            dispatcher.forward(request, response);
//            return;
//        }

        // Update only the level of the log
        Log log = new Log();
        log.setId(logId);
        log.setLevel(newLevel);
        logDao.update(log);

        String user = request.getParameter("user");
        String ipAddress = getIpAddress(request);

        Log addLog = new Log();
        addLog.setIp(ipAddress);
        addLog.setAddress("Log Management Update");
        addLog.setLevel(Log.INFO); // Use INFO level for the new log entry
        addLog.setValue("Checked: " + oldLog);
        addLog.setCreatedBy(user);
        addLog.setCreatedDate(new Date());
        logDao.insert(addLog);

//        System.out.println("Status value: " + log);
        response.sendRedirect(request.getContextPath() + "/Admin/log/list");
    }

    private String getIpAddress(HttpServletRequest request) {
        String ipAddress = InetAddress.getLoopbackAddress().getHostAddress();
        return ipAddress;
    }
}

