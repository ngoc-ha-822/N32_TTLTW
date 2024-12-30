package com.fit.nlu.DHHCeramic.controller.admin.blog;

import com.fit.nlu.DHHCeramic.model.Blog;
import com.fit.nlu.DHHCeramic.services.BlogService;
import com.fit.nlu.DHHCeramic.services.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "BlogEditController", value = "/Admin/news/edit")
public class BlogEditController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Blog blog = blogService.get(Integer.parseInt(id));
        request.setAttribute("blog", blog);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            request.getRequestDispatcher("/view/admin/view/editBlog.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/AdminLogin");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("title");
        String des = request.getParameter("des");
        String image = request.getParameter("image");
        String category = request.getParameter("blogCate");
        String date = request.getParameter("date");
        Blog blog = new Blog();
        blog.setId(Integer.parseInt(id));
        blog.setTitle(name);
        blog.setDes(des);
        blog.setImage(image);
        blog.setBlogCate(category);
        LocalDate date1 = LocalDate.parse(date);
        Date date2 = java.sql.Date.valueOf(date1);
        blog.setUpdatedBy(request.getParameter("user"));
        blog.setUpdatedDate(java.sql.Date.valueOf(LocalDate.now()));
        blog.setDate(date2);
        blogService.edit(blog);
        response.sendRedirect(request.getContextPath() + "/Admin/blog/list");
    }
}
