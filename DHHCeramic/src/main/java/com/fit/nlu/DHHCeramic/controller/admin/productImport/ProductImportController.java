package com.fit.nlu.DHHCeramic.controller.admin.productImport;

import com.fit.nlu.DHHCeramic.dao.impl.ProductImportDaoImpl;
import com.fit.nlu.DHHCeramic.model.ProductImport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/productImports")
public class ProductImportController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductImportDaoImpl productImportDao;

    public void init() {
        productImportDao = new ProductImportDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductImport> productImports = productImportDao.getAll();
        request.setAttribute("productImports", productImports);
        request.getRequestDispatcher("/view/admin/view/table-data-product_import.jsp").forward(request, response);
    }
}

