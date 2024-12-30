package com.fit.nlu.DHHCeramic.dao.impl;

import com.fit.nlu.DHHCeramic.dao.DiscountDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Discount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountDaoImpl extends JDBCConnection implements DiscountDao {

    @Override
    public void insert(Discount discount) {
        String sql = "INSERT INTO discounts(name, discountType, des, discountPercent, disId, startDate, endDate, createdBy, createdDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, discount.getName());
            ps.setString(2, discount.getDiscountType());
            ps.setString(3, discount.getDescription());
            ps.setDouble(4, discount.getDiscountPercent());
            ps.setInt(5, discount.getDisId());
            ps.setDate(6, new java.sql.Date(discount.getStartDate().getTime()));
            ps.setDate(7, new java.sql.Date(discount.getEndDate().getTime()));
            ps.setString(8, discount.getCreatedBy());
            ps.setDate(9, new java.sql.Date(discount.getCreatedDate().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Discount discount) {
        String sql = "UPDATE discounts SET name=?, discountType=?, des=?, discountPercent=?, disId=?, startDate=?, endDate=?, updateBy=?, updateDate=? WHERE id=?";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, discount.getName());
            ps.setString(2, discount.getDiscountType());
            ps.setString(3, discount.getDescription());
            ps.setDouble(4, discount.getDiscountPercent());
            ps.setInt(5, discount.getDisId());
            ps.setDate(6, new java.sql.Date(discount.getStartDate().getTime()));
            ps.setDate(7, new java.sql.Date(discount.getEndDate().getTime()));
            ps.setString(8, discount.getUpdatedBy());
            ps.setDate(9, new java.sql.Date(discount.getUpdatedDate().getTime()));
            ps.setInt(10, discount.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM discounts WHERE id=?";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Discount get(int id) {
        String sql = "SELECT * FROM discounts WHERE id=?";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Discount discount = new Discount();
                    discount.setId(rs.getInt("id"));
                    discount.setName(rs.getString("name"));
                    discount.setDiscountType(rs.getString("discountType"));
                    discount.setDescription(rs.getString("des"));
                    discount.setDiscountPercent(rs.getDouble("discountPercent"));
                    discount.setDisId(rs.getInt("disId"));
                    discount.setStartDate(rs.getDate("startDate"));
                    discount.setEndDate(rs.getDate("endDate"));
                    discount.setCreatedBy(rs.getString("createdBy"));
                    discount.setCreatedDate(rs.getDate("createdDate"));
                    discount.setUpdatedBy(rs.getString("updateBy"));
                    discount.setUpdatedDate(rs.getDate("updateDate"));
                    return discount;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Discount> getAll() {
        List<Discount> list = new ArrayList<>();
        String sql = "SELECT * FROM discounts";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Discount discount = new Discount();
                discount.setId(rs.getInt("id"));
                discount.setName(rs.getString("name"));
                discount.setDiscountType(rs.getString("discountType"));
                discount.setDescription(rs.getString("des"));
                discount.setDiscountPercent(rs.getDouble("discountPercent"));
                discount.setDisId(rs.getInt("disId"));
                discount.setStartDate(rs.getDate("startDate"));
                discount.setEndDate(rs.getDate("endDate"));
                discount.setCreatedBy(rs.getString("createdBy"));
                discount.setCreatedDate(rs.getDate("createdDate"));
                discount.setUpdatedBy(rs.getString("updateBy"));
                discount.setUpdatedDate(rs.getDate("updateDate"));
                list.add(discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Discount get(String name) {
        String sql = "SELECT * FROM discounts WHERE name=?";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Discount dis = new Discount();
                    dis.setId(rs.getInt("id"));
                    dis.setName(rs.getString("name"));
                    dis.setDiscountType(rs.getString("discountType"));
                    dis.setDescription(rs.getString("des"));
                    dis.setDiscountPercent(rs.getDouble("discountPercent"));
                    dis.setDisId(rs.getInt("disId"));
                    dis.setStartDate(rs.getDate("startDate"));
                    dis.setEndDate(rs.getDate("endDate"));
                    dis.setCreatedBy(rs.getString("createdBy"));
                    dis.setCreatedDate(rs.getDate("createdDate"));
                    dis.setUpdatedBy(rs.getString("updateBy"));
                    dis.setUpdatedDate(rs.getDate("updateDate"));
                    return dis;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Discount> search(String key) {
        List<Discount> list = new ArrayList<>();
        String sql = "SELECT * FROM discounts WHERE name LIKE ?";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + key + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Discount dis = new Discount();
                    dis.setId(rs.getInt("id"));
                    dis.setName(rs.getString("name"));
                    dis.setDiscountType(rs.getString("discountType"));
                    dis.setDescription(rs.getString("des"));
                    dis.setDiscountPercent(rs.getDouble("discountPercent"));
                    dis.setDisId(rs.getInt("disId"));
                    dis.setStartDate(rs.getDate("startDate"));
                    dis.setEndDate(rs.getDate("endDate"));
                    dis.setCreatedBy(rs.getString("createdBy"));
                    dis.setCreatedDate(rs.getDate("createdDate"));
                    dis.setUpdatedBy(rs.getString("updateBy"));
                    dis.setUpdatedDate(rs.getDate("updateDate"));
                    list.add(dis);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
