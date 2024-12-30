package com.fit.nlu.DHHCeramic.controller.client;


import com.fit.nlu.DHHCeramic.model.Blog;
import com.fit.nlu.DHHCeramic.services.BlogService;
import com.fit.nlu.DHHCeramic.services.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogController", value = "/blog")
public class BlogController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        int blogsPerPage = 6;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
        List<Blog> blogList = blogService.getBlogByPage(currentPage,blogsPerPage);
        request.setAttribute("blog",blogList);
        int numOfBlog = blogService.numOfBlogs();
        int numOfPages = numOfBlog / blogsPerPage;
        if (numOfPages % blogsPerPage > 0) {
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("blogsPerPage", blogsPerPage);

        System.out.println("Current Page: " + currentPage);
        System.out.println("Products Per Page: " + blogsPerPage);
        System.out.println("Total Pages: " + numOfPages);
        request.getRequestDispatcher("/view/client/view/blog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
