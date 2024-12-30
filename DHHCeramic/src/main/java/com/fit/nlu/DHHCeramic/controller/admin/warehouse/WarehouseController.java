package com.fit.nlu.DHHCeramic.controller.admin.warehouse;

import com.fit.nlu.DHHCeramic.dao.impl.ProductImportDaoImpl;
import com.fit.nlu.DHHCeramic.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/warehouse")
public class WarehouseController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductImportDaoImpl productImportDao;

    public void init() {
        productImportDao = new ProductImportDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> warehouse = productImportDao.getWarehouse();
        request.setAttribute("warehouse", warehouse);
        request.getRequestDispatcher("/view/admin/view/table-data-warehouse.jsp").forward(request, response);
    }
}

