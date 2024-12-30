package com.fit.nlu.DHHCeramic.services.impl.log;

import com.fit.nlu.DHHCeramic.dao.CategoryDao;
import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.CategoryDaoImpl;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Log;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

public class CategoryLogServiceImpl {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private LogDao logDao = new LogDaoImpl();

    public void logCategoryAdd(String username, Category newCategory, HttpServletRequest request) {
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("Category Management ADD");
        log.setLevel(Log.INFO);
        log.setValue("New Category: " + newCategory.toString());
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        logDao.insert(log);
    }

    public void logCategoryEdit(String username, Category oldCategory, Category newCategory, HttpServletRequest request) {
        // Tạo một đối tượng Log mới để lưu thông tin log
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("Category Management Edit");
        log.setLevel(Log.INFO);
        // Thiết lập giá trị của trường prevalue và value trong bản ghi log
        log.setPrevalue("Old Category: " + oldCategory.toString());
        log.setValue("New Category: " + newCategory.toString());
        // Thiết lập thông tin khác của bản ghi log
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        // Lưu bản ghi log vào cơ sở dữ liệu bằng LogDao
        logDao.insert(log);
    }

    public void logCategoryDelete(String username, Category deletedCategory, HttpServletRequest request) {
        // Tạo một đối tượng Log mới để lưu thông tin log
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("Category Management Delete");
        log.setLevel(Log.WARNING);

        // Thiết lập giá trị của trường prevalue và value trong bản ghi log
        log.setPrevalue("Deleted Category: " + deletedCategory.toString());
        log.setValue("Category deleted");
        // Thiết lập thông tin khác của bản ghi log
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        // Lưu bản ghi log vào cơ sở dữ liệu bằng LogDao
        logDao.insert(log);
    }
    public void logMultipleCategoryDelete(String user, List<Category> deletedCategories, HttpServletRequest request) {
        for (Category category : deletedCategories) {
            logCategoryDelete(user, category, request);
        }
    }


    private String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_FORWARDED");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        // Thêm xử lý cho địa chỉ IP là IPv6 loopback address
        if (ipAddress.equals("0:0:0:0:0:0:0:1") || ipAddress.equals("::1")) {
            try {
                ipAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return ipAddress;
    }
}