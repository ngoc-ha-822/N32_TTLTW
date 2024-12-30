package com.fit.nlu.DHHCeramic.services.impl.log;


import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fit.nlu.DHHCeramic.model.Log;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

public class UserLogServiceImpl {
    UserService userService = new UserServiceImpl();
    LogDao logDao = new LogDaoImpl();


    public void logUserAdd(String username, User newUser, HttpServletRequest request) {
        // Ghi log cho thao tác thêm sản phẩm
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("User Management ADD");
        log.setLevel(Log.ERROR); // Sử dụng mức độ INFO
        log.setValue("New User: " + newUser.toString());
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        // Thực hiện lưu log vào cơ sở dữ liệu hoặc hệ thống ghi log
        logDao.insert(log);
    }


    public void logUserEdit(String username, User oldUser, User newUser, HttpServletRequest request) {
        int userId = newUser.getId();
        // Lấy thông tin sản phẩm ban đầu từ cơ sở dữ liệu
        // Chỉ gọi UserService.get nếu oldUser hiện tại là null
        if (oldUser == null) {
            oldUser = userService.get(userId);
        }
        if (oldUser != null) {
            // Ghi log cho thao tác sửa sản phẩm
            Log log = new Log();
            // Lấy địa chỉ IP của người dùng
            String ipAddress = getIpAddress(request);
            log.setIp(ipAddress);
            log.setAddress("User Management Edit");
            log.setLevel(Log.INFO); // Sử dụng mức độ INFO
            log.setPrevalue("User ID: " + userId + ", Old Value: " + oldUser.toString());
            log.setValue("User Edited: " + newUser.toString());
            log.setCreatedBy(username);
            log.setCreatedDate(new Date());
            // Thực hiện lưu log vào cơ sở dữ liệu hoặc hệ thống ghi log
            logDao.insert(log);
        }
    }

    public void logUserDelete(String username, User deletedUser, HttpServletRequest request) {
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("User Management DELETE");
        log.setLevel(Log.WARNING); // Sử dụng mức độ INFO
        log.setPrevalue("Deleted User: " + deletedUser.toString());
        log.setValue("User deleted");
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        // Thực hiện lưu log vào cơ sở dữ liệu hoặc hệ thống ghi log
        logDao.insert(log);
    }

    private String getIpAddress(HttpServletRequest request) {
        String ipAddress = InetAddress.getLoopbackAddress().getHostAddress();
        return ipAddress;
    }
}
