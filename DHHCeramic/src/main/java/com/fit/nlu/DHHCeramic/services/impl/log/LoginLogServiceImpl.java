package com.fit.nlu.DHHCeramic.services.impl.log;

import com.fit.nlu.DHHCeramic.dao.IpAddressLockDao;
import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.UserDao;
import com.fit.nlu.DHHCeramic.dao.impl.IpAddressLockDaoImpl;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fit.nlu.DHHCeramic.dao.impl.UserDaoImpl;
import com.fit.nlu.DHHCeramic.model.Log;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.LogService;
import com.fit.nlu.DHHCeramic.tools.SendEmail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class LoginLogServiceImpl implements LogService {
    LogDao logDao = new LogDaoImpl();
    UserDao userDao = new UserDaoImpl();
    IpAddressLockDao lockDao = new IpAddressLockDaoImpl();

    // Số lần đăng nhập sai user cần ghi lại
    public static final int LOGIN_FAILED_LOG_USER = 2;

    // Số lần đăng nhập sai tối đa cho phép khi user đăng nhập sai
    public static final int LOGIN_FAILED_LOG_LOCK_USER = 5;

    public void logUserLoginFailed(String username, String ipAddress, Integer failedLoginCount, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userLoginFailed = (String) session.getAttribute("userLoginFailed");
        if (failedLoginCount == null) {
            failedLoginCount = 0;
        }
        if (userLoginFailed == null) {
            session.setAttribute("userLoginFailed", username);
        } else if (username.equals(session.getAttribute("userLoginFailed"))) {
            failedLoginCount++;
            session.setAttribute("failedUserLoginCount", failedLoginCount);
            session.setAttribute("userLoginFailed", username);
            if (failedLoginCount == LOGIN_FAILED_LOG_USER && failedLoginCount < LOGIN_FAILED_LOG_LOCK_USER) {
                // Gửi email cảnh báo khi số lần đăng nhập sai đạt ngưỡng
                String subject = "Account Security Alert";
                String body = "Your account has experienced multiple failed login attempts. Please verify your identity.";
                SendEmail.sendMail(userDao.get(username).getEmail(), subject, body);

                // Ghi log user đăng nhập sai nhiều lần
                Log log = new Log();
                log.setIp(ipAddress);
                log.setLevel(Log.ERROR); // Đăng nhập không thành công, sử dụng mức độ ERROR
                log.setAddress("Login");
                log.setPrevalue("User login failed many times");
                log.setValue("User " + username + " login failed " + failedLoginCount + " times"); // Lưu tên người dùng đăng nhập không thành công
                log.setCreatedDate(new Date());
                logDao.insert(log);
            } else if (failedLoginCount == LOGIN_FAILED_LOG_LOCK_USER) {
                // Gửi email cảnh báo và khóa tài khoản khi đăng nhập sai quá nhiều lần
                String subject = "Account Security Alert";
                String body = "Your account has been locked due to multiple failed login attempts. Please contact support for assistance.";
                SendEmail.sendMail(userDao.get(username).getEmail(), subject, body);
//                SendEmail.sendMail();
                // Khóa tài khoản
                // Lấy thông tin người dùng từ cơ sở dữ liệu
                User user = userDao.get(username);
                // Nếu người dùng tồn tại
                if (user != null) {
                    // Khóa tài khoản bằng cách đặt status thành 0
                    user.setStatus(0);
                    // Cập nhật thông tin người dùng
                    userDao.edit(user);
                }
                // Ghi log user đăng nhập sai nhiều lần, khóa tài khoản
                Log log = new Log();
                log.setIp(ipAddress);
                log.setLevel(Log.WARNING); // Đăng nhập không thành công, sử dụng mức độ ERROR
                log.setAddress("Login");
                log.setPrevalue("User login failed many times");
                log.setValue("User " + username + " login failed " + failedLoginCount + " times, lock user"); // Lưu tên người dùng đăng nhập không thành công
                log.setCreatedDate(new Date());
                logDao.insert(log);
            }
        }
    }

    // Phương thức ghi log và gửi email cảnh báo khi IP không quen thuộc đăng nhập
    public void logIpAddressLogin(String ipAddress, String username, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String ipLoginFailed = (String) session.getAttribute("ipAddressLoginFailed");
        if (ipLoginFailed == null || !ipAddress.equals(ipLoginFailed)) {
            session.setAttribute("ipAddressLoginFailed", ipAddress);

            // Gửi email cảnh báo cho người dùng xác nhận nếu có sự thay đổi trong việc đăng nhập từ IP mới
            String subject = "Account Security Alert";
            String body = "Your account has been logged in from an unfamiliar IP address. If this was not you, please take necessary actions to secure your account.";
            SendEmail.sendMail(userDao.get(username).getEmail(), subject, body);

            // Ghi log cho địa chỉ IP không quen thuộc
            Log log = new Log();
            log.setIp(ipAddress);
            log.setLevel(Log.WARNING); // Sử dụng mức độ WARNING
            log.setAddress("Login");
            log.setPrevalue("Unfamiliar IP address login");
            log.setValue("An attempt to login from an unfamiliar IP address: " + ipAddress); // Ghi log về địa chỉ IP không quen thuộc
            log.setCreatedDate(new Date());
            logDao.insert(log);

            // Khóa địa chỉ IP
            lockDao.lockIpAddress(ipAddress, "Attempted login from an unfamiliar IP address");
        }
    }


    @Override
    public void insert(Log log) {

    }

    @Override
    public void update(Log log) {

    }

    @Override
    public void delete(int id) {

    }
    @Override
    public List<Log> loadAllLog() {
        return null;
    }

    @Override
    public Log getLogById(int id) {
        return null;
    }

    @Override
    public void checked(int id) {

    }
}
