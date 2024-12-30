package com.fit.nlu.DHHCeramic.dao.impl;


import com.fit.nlu.DHHCeramic.dao.CommentDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Comment;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl extends JDBCConnection implements CommentDao {
    @Override
    public void insert(Comment comment) {
        String sql = "INSERT INTO comments(productId, userId, rating, content, time) VALUES (?,?,?,?,?)";
        Connection con = getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, comment.getProduct_id().getId());
            ps.setInt(2, comment.getUsername().getId());
            ps.setInt(3, comment.getRating());
            ps.setString(4, comment.getContent());
            ps.setDate(5, (Date) comment.getTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Comment oldComment) {
//        String sql = "UPDATE comments SET username = ? , productId = ?,avatar=?,rating=?, content = ?,time=? WHERE id = ?";
//        Connection con = getJDBCConnection();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, oldComment.getUsername());
//            ps.setInt(2, oldComment.getProduct_id());
//            ps.setInt(4, oldComment.getRating());
//            ps.setString(5, oldComment.getContent());
//            ps.setDate(6, (Date) oldComment.getTime());
//            ps.setInt(7, oldComment.getId());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM comments WHERE id=?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Comment get(int id) {
        String sql = "SELECT user.username, comments.productId, comments.avatar, comments.rating, comments.content, comments.time "
                + " FROM comments join users on comments.userId = users.id" + " WHERE comments.id=?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Comment comment = new Comment();
                User user = new User();
                Product product = new Product();
                product.setId(Integer.parseInt("productId"));
                user.setUsername("username");
                comment.setUsername(user);
                comment.setProduct_id(product);
                comment.setRating(rs.getInt("rating"));
                comment.setContent(rs.getString("content"));
                comment.setTime(rs.getDate("time"));
                return comment;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public List<Comment> getAll() {
        List<Comment> commentList = new ArrayList<Comment>();
        String sql = "SELECT comments.id, user.username, comments.productId, comments.avatar, comments.rating, comments.content, comments.time "
                + " FROM comments join users on comments.userId = users.id";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();
                User user = new User();
                comment.setId(rs.getInt("id"));
                Product product = new Product();
                product.setId(Integer.parseInt("productId"));
                user.setUsername("username");
                comment.setUsername(user);
                comment.setProduct_id(product);
                comment.setRating(rs.getInt("rating"));
                comment.setContent(rs.getString("content"));
                comment.setTime(rs.getDate("time"));
                commentList.add(comment);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return commentList;
    }

    public double getAverageRating(int productId) {
        try {
            String sql = "SELECT AVG(rating) AS avgRating FROM comments WHERE productId = ?";
            Connection conn = JDBCConnection.getJDBCConnection();
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, productId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getDouble("avgRating");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
        return 0.0; // Trả về giá trị mặc định nếu có lỗi
    }
    public int countComment(int productId) {
        try {
            String sql = "SELECT COUNT(id) as numOfComments FROM comments where productId = ?";
            Connection conn = JDBCConnection.getJDBCConnection();
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, productId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("numOfComments");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
        return 0;
    }
}
