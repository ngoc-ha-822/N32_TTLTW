package com.fit.nlu.DHHCeramic.dao.impl;

import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.model.ProductImport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImportDaoImpl extends JDBCConnection {
    // Phương thức kết nối được giả định đã có trong lớp JDBCConnection
    public List<ProductImport> getAll() {
        List<ProductImport> productImports = new ArrayList<>();
        String sql = "SELECT pi.id, pi.quantity, pi.createdAt, pi.price, pi.importBatch, " +
                "p.id as productId, p.name, p.price as productPrice " +
                "FROM product_imports pi " +
                "JOIN products p ON pi.productId = p.id";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductImport productImport = new ProductImport();
                productImport.setId(rs.getInt("id"));
                productImport.setQuantity(rs.getInt("quantity"));
                productImport.setCreatedAt(rs.getTimestamp("createdAt"));
                productImport.setPrice(rs.getLong("price"));
                productImport.setImportBatch(rs.getInt("importBatch"));

                Product product = new Product();
                product.setId(rs.getInt("productId"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("productPrice"));

                productImport.setProduct(product);

                productImports.add(productImport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productImports;
    }
    // Method to update an existing ProductImport
    public void edit(ProductImport productImport) {
        String sql = "UPDATE product_imports SET productId = ?, quantity = ?, createdAt = ?, price = ?, importBatch = ? WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productImport.getProduct().getId());
            ps.setInt(2, productImport.getQuantity());
            ps.setTimestamp(3, new java.sql.Timestamp(productImport.getCreatedAt().getTime()));
            ps.setLong(4, productImport.getPrice());
            ps.setInt(5, productImport.getImportBatch());
            ps.setInt(6, productImport.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public ProductImport get(int id) {
        String sql = "SELECT pi.id, pi.quantity, pi.createdAt, pi.price, pi.importBatch, " +
                "p.id as productId, p.name, p.price as productPrice " +
                "FROM product_imports pi " +
                "JOIN products p ON pi.productId = p.id " +
                "WHERE pi.id = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        ProductImport productImport = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                productImport = new ProductImport();
                productImport.setId(rs.getInt("id"));
                productImport.setQuantity(rs.getInt("quantity"));
                productImport.setCreatedAt(rs.getTimestamp("createdAt"));
                productImport.setPrice(rs.getLong("price"));
                productImport.setImportBatch(rs.getInt("importBatch"));

                Product product = new Product();
                product.setId(rs.getInt("productId"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("productPrice"));

                productImport.setProduct(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productImport;
    }

    public List<Product> getWarehouse() {
        List<Product> warehouse = new ArrayList<>();
        String sql = "SELECT \n" +
                "    p.id AS productId, \n" +
                "    p.name AS productName, \n" +
                "    p.image,  \n" +
                "    IFNULL(od.productOut, 0) AS productOut, \n" +
                "    (pi.quantity - IFNULL(od.productOut, 0)) AS remainingStock,\n" +
                "    CASE\n" +
                "        WHEN pi.quantity IS NULL THEN 'Hết hàng'\n" +
                "        WHEN (pi.quantity - IFNULL(od.productOut, 0)) <= pi.quantity * 0.2 THEN 'Sắp hết hàng'\n" +
                "        ELSE 'Còn hàng'\n" +
                "    END AS stockStatus\n" +
                "FROM products p \n" +
                "LEFT JOIN (\n" +
                "    SELECT od.productId, IFNULL(SUM(od.quantity), 0) AS productOut \n" +
                "    FROM order_details od \n" +
                "    JOIN orders o ON od.orderId = o.id AND o.status NOT LIKE 'Đã hủy' \n" +
                "    GROUP BY od.productId\n" +
                ") AS od ON od.productId = p.id \n" +
                "LEFT JOIN product_imports pi ON pi.productId = p.id \n" +
                "GROUP BY p.id, p.image, p.name, pi.quantity;\n";

        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("productId"));
                product.setImage(rs.getString("image"));
                product.setName(rs.getString("productName"));
                product.setRemainingStock(rs.getInt("remainingStock"));
                product.setStockStatus(rs.getString("stockStatus"));

                warehouse.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return warehouse;
    }
    public List<Product> getStock() {
        List<Product> warehouse = new ArrayList<>();
        String sql = "SELECT \n" +
                "    p.id AS productId, \n" +
                "    p.name AS productName, \n" +
                "    p.image,  \n" +
                "    IFNULL(od.productOut, 0) AS productOut, \n" +
                "    (pi.quantity - IFNULL(od.productOut, 0)) AS remainingStock,\n" +
                "    CASE\n" +
                "        WHEN pi.quantity IS NULL THEN 'Hết hàng'\n" +
                "        WHEN (pi.quantity - IFNULL(od.productOut, 0)) <= pi.quantity * 0.5 THEN 'Sắp hết hàng'\n" +
                "        ELSE 'Còn hàng'\n" +
                "    END AS stockStatus\n" +
                "FROM products p \n" +
                "LEFT JOIN (\n" +
                "    SELECT od.productId, IFNULL(SUM(od.quantity), 0) AS productOut \n" +
                "    FROM order_details od \n" +
                "    JOIN orders o ON od.orderId = o.id AND o.status NOT LIKE 'Đã hủy' \n" +
                "    GROUP BY od.productId\n" +
                ") AS od ON od.productId = p.id \n" +
                "LEFT JOIN product_imports pi ON pi.productId = p.id \n" +
                "GROUP BY p.id, p.image, p.name, pi.quantity\n" +
                "HAVING stockStatus = 'Sắp hết hàng';\n";

        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("productId"));
                product.setImage(rs.getString("image"));
                product.setName(rs.getString("productName"));
                product.setRemainingStock(rs.getInt("remainingStock"));
                product.setStockStatus(rs.getString("stockStatus"));

                warehouse.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return warehouse;
    }

}

