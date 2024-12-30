package com.fit.nlu.DHHCeramic.controller.admin.product;

import com.fit.nlu.DHHCeramic.model.MoreImage;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MoreImageController", value = "/Admin/product/image-add")
public class MoreImageController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("/view/admin/view/addMoreImages.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro_id = request.getParameter("id");
        String img1 = request.getParameter("image1");
        String img2 = request.getParameter("image2");
        String img3 = request.getParameter("image3");
        String img4 = request.getParameter("image4");
        MoreImage moreImage = new MoreImage();
        moreImage.setProductId(Integer.parseInt(pro_id));
        moreImage.setImage1(img1);
        moreImage.setImage2(img2);
        moreImage.setImage3(img3);
        moreImage.setImage4(img4);
        productService.setMoreImage(moreImage);
        response.sendRedirect(request.getContextPath() + "/Admin/product/list");
    }
}
