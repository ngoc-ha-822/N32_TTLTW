package com.fit.nlu.DHHCeramic.controller.client.product;


import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/product/category")
public class ProductSearchByCategory extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cate_id = request.getParameter("cate_id");
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
        List<Product> productListCate = productService.getProductByCategory(currentPage, productsPerPage, Integer.parseInt(cate_id));
        int numOfProduct = productService.numOfProducts();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productsPerPage", productsPerPage);
        // In giá trị ra console để kiểm tra
        System.out.println("cate_id: " + cate_id);
        System.out.println("currentPage: " + currentPage);
        System.out.println("productsPerPage: " + productsPerPage);


        List<Product> productSearchByCategory = productService.searchByCategory(Integer.parseInt(cate_id));
        PrintWriter out = response.getWriter();
        for (Product p : productSearchByCategory) {
            out.println("    <div class=\"col-lg-4 col-md-6 col-sm-6 show-product\"");
            out.println("          onclick=\"window.location.href='/DHHCeramic/product/detail?id=" + p.getId()+ "'\">");
            out.println("        <div class=\"product__item\">");
            out.println("            <div class=\"product__item__pic set-bg\" data-setbg=\"" + p.getImage() + "\">");
            out.println("                <ul class=\"product__item__pic__hover\">");
            out.println("                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>");
            out.println("                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>");
            out.println("                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>");
            out.println("                </ul>");
            out.println("            </div>");
            out.println("            <div class=\"product__item__text\">");
            out.println("                <span>" + p.getCategory().getName() + "</span>");
            out.println("                <h6><a href=\"#\">" + p.getName() + "</a></h6>");
            out.println("                <h5>" + p.getPrice() + " VND</h5>");
            out.println("            </div>");
            out.println("        </div>");
            out.println("    </div>");
        }
        out.println("</div>");

        out.println("<ul class=\"pagination\">");
        if (currentPage != 1) {
            out.println("    <li class=\"page-item\"><a class=\"page-link\" href=\"?page=" + (currentPage - 1) + "\">&laquo;</a></li>");
        }

        int startPage = currentPage - 5;
        if (startPage < 1) {
            startPage = 1;
        }

        int endPage = startPage + 9;
        if (endPage > numOfPages) {
            endPage = numOfPages;
        }

        for (int i = startPage; i <= endPage; i++) {
            if (currentPage == i) {
                out.println("    <li class=\"page-item active\"><a class=\"page-link\">" + i + "</a></li>");
            } else {
                out.println("    <li class=\"page-item\"><a class=\"page-link\" href=\"?page=" + i + "\">" + i + "</a></li>");
            }
        }

        if (currentPage < numOfPages) {
            out.println("    <li class=\"page-item\"><a class=\"page-link\" href=\"?page=" + (currentPage + 1) + "\">&raquo;</a></li>");
        }
        out.println("</ul>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
