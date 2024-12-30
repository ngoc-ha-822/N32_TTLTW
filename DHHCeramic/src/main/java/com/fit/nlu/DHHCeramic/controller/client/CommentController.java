package com.fit.nlu.DHHCeramic.controller.client;


import com.fit.nlu.DHHCeramic.dao.ProductDao;
import com.fit.nlu.DHHCeramic.dao.UserDao;
import com.fit.nlu.DHHCeramic.dao.impl.CommentDaoImpl;
import com.fit.nlu.DHHCeramic.dao.impl.ProductDaoImpl;
import com.fit.nlu.DHHCeramic.dao.impl.UserDaoImpl;
import com.fit.nlu.DHHCeramic.model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

@WebServlet(name = "CommentController", value = "/comment")
public class CommentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final CommentDaoImpl commentDao = new CommentDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("user");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String content = request.getParameter("message1");

        Comment comment = new Comment();
        comment.setProduct_id(productDao.get(productId));
        comment.setUsername(userDao.get(username));
        comment.setRating(rating);
        comment.setContent(content);
        comment.setTime(Date.valueOf(LocalDate.now()));
        commentDao.insert(comment);
        System.out.println(comment);
        // Điều hướng lại trang chi tiết sản phẩm
        response.sendRedirect(request.getContextPath() + "/product/detail?id=" + productId);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
