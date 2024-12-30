package com.fit.nlu.DHHCeramic.dao.impl;


import com.fit.nlu.DHHCeramic.dao.BlogDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDaoImpl implements BlogDao {
    @Override
    public void insert(Blog blog) {
        String sql = "INSERT INTO blogs(image, blogCate, date, title, des, createdBy, createdDate) VALUES (?,?,?,?,?,?,?)";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, blog.getImage());
            ps.setString(2, blog.getBlogCate());
            ps.setDate(3, (Date) blog.getDate());
            ps.setString(4, blog.getTitle());
            ps.setString(5, blog.getDes());
            ps.setString(6, blog.getCreatedBy());
            ps.setDate(7, (Date) blog.getCreatedDate());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Blog blog) {
        String sql = "UPDATE blogs SET blogs.title = ? , blogs.image = ?,blogCate=?, date = ?,des=?, updateBy= ?,updateDate=?  WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getImage());
            ps.setString(3, blog.getBlogCate());
            ps.setDate(4, (Date) blog.getDate());
            ps.setString(5, blog.getDes());
            ps.setString(6, blog.getUpdatedBy());
            ps.setDate(7, (Date) blog.getUpdatedDate());
            ps.setInt(8, blog.getId());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM blogs WHERE id=?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Blog get(int id) {
        String sql = "SELECT id, blogs.image,blogs.blogCate,blogs.date,blogs.title,blogs.des"
                + " FROM blogs  WHERE blogs.id=?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setImage(rs.getString("image"));
                blog.setDate(rs.getDate("date"));
                blog.setBlogCate(rs.getString("blogCate"));
                blog.setTitle(rs.getString("title"));
                blog.setDes(rs.getString("des"));
                return blog;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Blog> getAll() {
        List<Blog> blogList = new ArrayList<>();
        String sql = "SELECT blogs.id, blogs.image,blogs.blogCate,blogs.date,blogs.title,blogs.des"
                + " FROM blogs  ";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setImage(rs.getString("image"));
                blog.setDate(rs.getDate("date"));
                blog.setBlogCate(rs.getString("blogCate"));
                blog.setTitle(rs.getString("title"));
                blog.setDes(rs.getString("des"));
                blogList.add(blog);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blogList;
    }

    @Override
    public List<Blog> getBlogByPage(int currentPage, int blogsPerPage) {
        List<Blog> blogList = new ArrayList<Blog>();
        String sql = "SELECT blogs.id, blogs.title , blogs.blogCate, blogs.date, blogs.image, blogs.des"
                + " FROM blogs  LIMIT ?,?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentPage * blogsPerPage - blogsPerPage);
            ps.setInt(2, blogsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setImage(rs.getString("image"));
                blog.setDate(rs.getDate("date"));
                blog.setBlogCate(rs.getString("blogCate"));
                blog.setTitle(rs.getString("title"));
                blog.setDes(rs.getString("des"));
                blogList.add(blog);
            }
            System.out.println("Blog List: " + blogList);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blogList;

    }

    @Override
    public int getNumOfBlogs() {
        return getAll().size();
    }

}


