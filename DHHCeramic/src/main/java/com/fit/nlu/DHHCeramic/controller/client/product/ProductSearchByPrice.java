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

@WebServlet(name = "ProductSearchByPrice", value = "/productSearchByPrice")
public class ProductSearchByPrice extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
        String priceFrom = request.getParameter("priceFrom");
        String priceTo = request.getParameter("priceTo");
        List<Product> productSearchByPrice = productService.searchByPrice(Integer.parseInt(priceFrom), Integer.parseInt(priceTo), currentPage, productsPerPage);
        int numOfProduct = productSearchByPrice.size();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        for (Product p : productSearchByPrice) {
            out.println("<div class=\"col-lg-4 col-md-6 col-sm-6 show-product\"");
            out.println("     onclick=\"window.location.href='${pageContext.request.contextPath}/product/detail?id=" + p.getId()+ "'\">");
            out.println("    <div class=\"product__item\">");
            out.println("        <div class=\"product__item__pic set-bg\" data-setbg=\"" + p.getImage() + "\">");
            out.println("            <ul class=\"product__item__pic__hover\">");
            out.println("                <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>");
            out.println("                <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>");
            out.println("                <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>");
            out.println("            </ul>");
            out.println("        </div>");
            out.println("        <div class=\"product__item__text\">");
            out.println("            <span>" + p.getCategory().getName() + "</span>");
            out.println("            <h6><a href=\"#\">" + p.getName() + "</a></h6>");
            out.println("            <h5>" + p.getPrice() + " VND</h5>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("</div>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
