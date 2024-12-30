package com.fit.nlu.DHHCeramic.controller.client.product;


import com.fit.nlu.DHHCeramic.model.Comment;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.services.CommentService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.CommentServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/product/detail")
public class ProductDetailController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList;
        String id = request.getParameter("id");
        Product product = productService.get(Integer.parseInt(id));
        Set<Integer> displayedProductIds = new HashSet<>();
        Map<Integer, Double> productRatings = new HashMap<>();
        int numberOfComments = commentService.countComment(Integer.parseInt(id));
        productList = productService.getAll();
        Iterator<Product> iterator = productList.iterator();

        int fullStars = 0;
        boolean hasHalfStar = false;
        Product p = null;
        double averageRating = 0;
        while (iterator.hasNext()) {
            p = iterator.next();
            // Kiểm tra xem sản phẩm đã được hiển thị chưa
            if (displayedProductIds.contains(p.getId())) {
                continue; // Đã hiển thị, bỏ qua lần lặp này
            }
            averageRating = commentService.getAverageRating(p.getId());
            productRatings.put(p.getId(), averageRating);
            if (Double.isNaN(averageRating)) {
                averageRating = 0.0; // Gán giá trị mặc định khi không có đánh giá
            }
            fullStars = (int) averageRating;
            hasHalfStar = averageRating - fullStars > 0;
            // Thêm sản phẩm vào danh sách đã hiển thị
            displayedProductIds.add(p.getId());
        }
        int id_cate = productService.getCateId(Integer.parseInt(id));
        List<Product> categories = productService.searchByCategory(id_cate);
        List<String> moreImg = productService.getMoreImage(Integer.parseInt(id));
        List<Comment> listComment = productService.getAllProductComments(Integer.parseInt(id));
        request.setAttribute("productRatings", productRatings);
        request.setAttribute("numberOfComments", numberOfComments);
        request.setAttribute("categories", categories);
        request.setAttribute("moreImg", moreImg);
        request.setAttribute("product", product);
        request.setAttribute("listComment", listComment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/view/shop-details.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
