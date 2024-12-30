package com.fit.nlu.DHHCeramic.controller.client.product;


import com.fit.nlu.DHHCeramic.model.Category;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product/list"})
public class ProductListClientController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String type = request.getParameter("type");
        List<Product> productList;
        List<Product> productSale;
        List<Category> categoryList;
        List<Product> products = productService.getAll();
        request.setAttribute("products",products.size());
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
//        if (type==null) {
        productList = productService.getProductByPage(currentPage, productsPerPage);
        productSale = productService.getProductBySale();
        categoryList = cateService.getAll();
/*
        } else if(type.equals("desc")){
            productList = productService.getProductByDESC(currentPage, productsPerPage);
        }
        else{
            productList = productService.getProductByACS(currentPage, productsPerPage);

        }
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getSalePrice()>o2.getSalePrice() ? -1: (o1.getSalePrice()<o2.getSalePrice())?1:0;
            }
        });
*/

        request.setAttribute("productList", productList);
        request.setAttribute("productSale", productSale);
        request.setAttribute("categoryList", categoryList);
        int numOfProduct = productService.numOfProducts();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }

        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productsPerPage", productsPerPage);

//        List<Product> productList = productService.getAll();
//        request.setAttribute("productList", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/view/shop-grid.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}