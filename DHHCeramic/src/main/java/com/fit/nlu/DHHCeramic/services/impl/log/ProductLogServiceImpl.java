package com.fit.nlu.DHHCeramic.services.impl.log;

import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.dao.impl.LogDaoImpl;
import com.fit.nlu.DHHCeramic.model.Log;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.LogService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

public class ProductLogServiceImpl implements LogService {
    ProductService productService = new ProductServiceImpl();
    LogDao logDao = new LogDaoImpl();

    public ProductLogServiceImpl() {
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

    public void logProductAdd(String username, Product newProduct, HttpServletRequest request) {
        // Ghi log cho thao tác thêm sản phẩm
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("Product Management ADD");
        log.setLevel(Log.INFO); // Sử dụng mức độ INFO
        log.setValue("New Product: " + newProduct.toString());
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        // Thực hiện lưu log vào cơ sở dữ liệu hoặc hệ thống ghi log
        logDao.insert(log);
    }


    public void logProductEdit(String username, Product oldProduct, Product newProduct, HttpServletRequest request) {
        int productId = newProduct.getId();
        // Lấy thông tin sản phẩm ban đầu từ cơ sở dữ liệu
        // Chỉ gọi productService.get nếu oldProduct hiện tại là null
        if (oldProduct == null) {
            oldProduct = productService.get(productId);
        }
        if (oldProduct != null) {
            // Ghi log cho thao tác sửa sản phẩm
            Log log = new Log();
            // Lấy địa chỉ IP của người dùng
            String ipAddress = getIpAddress(request);
            log.setIp(ipAddress);
            log.setAddress("Product Management Edit");
            log.setLevel(Log.INFO); // Sử dụng mức độ INFO
            log.setPrevalue("Product ID: " + productId + ", Old Value: " + oldProduct.toString());
            log.setValue("Product Edited: " + newProduct.toString());
            log.setCreatedBy(username);
            log.setCreatedDate(new Date());
            // Thực hiện lưu log vào cơ sở dữ liệu hoặc hệ thống ghi log
            logDao.insert(log);
        }
    }

    public void logProductDelete(String username, Product deletedProduct, HttpServletRequest request) {
        Log log = new Log();
        String ipAddress = getIpAddress(request);
        log.setIp(ipAddress);
        log.setAddress("Product Management DELETE");
        log.setLevel(Log.WARNING); // Sử dụng mức độ INFO
        log.setPrevalue("Deleted Product: " + deletedProduct.toString());
        log.setValue("Product deleted");
        log.setCreatedBy(username);
        log.setCreatedDate(new Date());
        // Thực hiện lưu log vào cơ sở dữ liệu hoặc hệ thống ghi log
        logDao.insert(log);
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
