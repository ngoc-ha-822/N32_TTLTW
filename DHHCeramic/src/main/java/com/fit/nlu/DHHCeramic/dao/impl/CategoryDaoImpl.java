package com.fit.nlu.DHHCeramic.dao.impl;


import com.fit.nlu.DHHCeramic.dao.CategoryDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO categories(id, cateName, status, createdBy, createdDate) VALUES (?, ?, ?, ?, ?)";
        Connection con = getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());
            ps.setInt(3, category.getStatus());
            ps.setString(4, category.getCreatedBy());
            if (category.getCreatedDate() != null) {
                ps.setDate(5, new java.sql.Date(category.getCreatedDate().getTime()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Category category) {
        String sql = "UPDATE categories SET cateName=?, status=?, updateBy =?, updateDate=? WHERE id = ?";
        Connection con = getJDBCConnection();
        System.out.println("DAO" + category);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getStatus());
            ps.setString(3, category.getUpdatedBy());
            ps.setDate(4, (Date) category.getUpdatedDate());
            ps.setInt(5, category.getId());
            System.out.println(category);
            ps.executeUpdate();
            System.out.println("Updated status: " + category.getStatus());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        if (hasProducts(id)) {
            throw new IllegalStateException("Không thể xóa danh mục có chứa sản phẩm.");
        }
        String sql = "DELETE FROM categories WHERE id = ?";
        Connection con = getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean hasProducts(int categoryId) {
        // Viết truy vấn SQL để đếm số lượng sản phẩm trong danh mục
        String sql = "SELECT COUNT(*) FROM products WHERE cateId = ?";
        Connection con = getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM categories WHERE id = ? ";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("cateName"));
                category.setStatus(rs.getInt("status"));
                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM categories";
        Connection conn = getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("cateName"));
                category.setStatus(rs.getInt("status"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public List<Category> search(String keyword) {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM categories WHERE name LIKE ? ";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category get(String name) {
        String sql = "SELECT * FROM categories WHERE cateName = ? ";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("cateName"));

                return category;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

