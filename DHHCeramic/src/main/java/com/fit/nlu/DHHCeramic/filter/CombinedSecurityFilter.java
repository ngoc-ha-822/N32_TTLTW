//package com.fit.nlu.DHHCeramic.filter;
//
//import com.fit.nlu.DHHCeramic.model.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/member/*", "/Admin/*", "/Admin/product/*"})
//public class CombinedSecurityFilter implements Filter {
//
//    @Override
//    public void destroy() {}
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resq = (HttpServletResponse) response;
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("account");
//
//        if (user == null) {
//            resq.sendRedirect(req.getContextPath() + "/login");
//            return;
//        }
//
//        String requestURI = req.getRequestURI();
//
//        // Kiểm tra các URL bắt đầu bằng /member/
//        if (requestURI.startsWith("/member/")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // Kiểm tra các URL bắt đầu bằng /Admin/
//        if (requestURI.startsWith("/Admin/")) {
//            // Kiểm tra nếu người dùng là admin (roleId = 1)
//            if (user.getRoleId() == 1) {
//                chain.doFilter(request, response);
//                return;
//            }
//
//            // Kiểm tra nếu người dùng có roleId = 3
//            if (user.getRoleId() == 3) {
//                // Kiểm tra nếu URL bắt đầu bằng /Admin/product/
//                if (requestURI.startsWith("/Admin/product/")) {
//                    if (!requestURI.contains("/Admin/user/delete") && !requestURI.contains("/Admin/user/edit") && !requestURI.contains("/Admin/user/add")) {
//                        chain.doFilter(request, response);
//                        return;
//                    }
//                }
//                // Hoặc nếu URL là /Admin/welcome
//                if (requestURI.equals("/Admin/welcome")) {
//                    chain.doFilter(request, response);
//                    return;
//                }
//            }
//        }
//        // Nếu không đáp ứng bất kỳ điều kiện nào ở trên, chuyển hướng đến trang báo lỗi
//        resq.sendRedirect(req.getContextPath() + "/error");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {}
//}
