package com.fit.nlu.DHHCeramic.controller.admin.comment;


import com.fit.nlu.DHHCeramic.model.Comment;
import com.fit.nlu.DHHCeramic.services.CommentService;
import com.fit.nlu.DHHCeramic.services.impl.CommentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommentListController", value = "/Admin/comment/list")
public class CommentListController extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> commentList = commentService.getAll();
        request.setAttribute("commentList", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/table-data-comment.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
