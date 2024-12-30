package com.fit.nlu.DHHCeramic.dao.impl;


import com.fit.nlu.DHHCeramic.dao.UserDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends JDBCConnection implements UserDao {


    @Override
    public void insert(User user) {
        System.out.println("Email: " + user.getEmail());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        int roleId = 0;
        int status = 0;
        String sql = "INSERT INTO users(email, fullname, facebook, username, password,avatar,address,phoneNumber,birthday,status,roleId,createdBy,createdDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFullname());
            ps.setString(3, "");
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getAvatar());
            ps.setString(7, "");
            ps.setString(8, "");
            ps.setDate(9, (Date) user.getBirthday());
            ps.setInt(10, 1);

            try {
                if (user.getRoleId() == 1) {
                    roleId = 1;
                } else {
                    roleId = 2;
                }
            } catch (Exception e) {
                roleId = 2;
            }

            ps.setInt(11, roleId);
            ps.setString(12, user.getCreatedBy());
            ps.setDate(13,  new java.sql.Date(user.getCreatedDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void edit(User user) {
        String sql = "UPDATE users SET email=?, fullname=?, facebook=?, username=?, password=?, avatar=?, address=?, phoneNumber=?, birthday=?, status=?, roleId=?, updateBy=?, updateDate=? WHERE id=?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getFacebook());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getAvatar());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPhoneNumber());
            ps.setDate(9, (Date) user.getBirthday());
            ps.setInt(10, user.getStatus());
            ps.setInt(11, user.getRoleId());
            ps.setString(12, user.getUpdatedBy());
            ps.setDate(13, (Date) user.getUpdatedDate());
            ps.setInt(14, user.getId());
            ps.executeUpdate();
            System.out.println("Phone number: " + user.getPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
//             TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM users WHERE username = ? ";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setFacebook(rs.getString("facebook"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setStatus(rs.getInt("status"));
                user.setRoleId(rs.getInt("roleId")); // Thay đổi ở đây

                return user;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM users WHERE id = ? ";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setFacebook(rs.getString("facebook"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setStatus(rs.getInt("status"));
                user.setRoleId(rs.getInt("roleId")); // Thay đổi ở đây

                return user;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public User getByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setFacebook(rs.getString("facebook"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setStatus(rs.getInt("status"));
                user.setRoleId(rs.getInt("roleId")); // Thay đổi ở đây

                return user;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM users";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setFacebook(rs.getString("facebook"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setStatus(rs.getInt("status"));
                user.setRoleId(rs.getInt("roleId")); // Thay đổi ở đây

                userList.add(user);

                System.out.println("Câu truy vấn SQL: " + sql);
                System.out.println("Number of Products in ResultSet: " + userList);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public List<User> search(String keyword) {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM users WHERE name LIKE ? ";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setFacebook(rs.getString("facebook"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setStatus(rs.getInt("status"));
                user.setRoleId(rs.getInt("roleId")); // Thay đổi ở đây

                userList.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;
    }

    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String query = "select * from users where email = ?";

            PreparedStatement psmt = conn.prepareStatement(query);

            psmt.setString(1, email);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                duplicate = true;
            }
            psmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return duplicate;
    }

    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String query = "select * from users  where username = ?";

            PreparedStatement psmt = conn.prepareStatement(query);

            psmt.setString(1, username);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                duplicate = true;
            }
            psmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return duplicate;
    }

    @Override
    public String getPassword(String email) {
        String sql = "SELECT users.password FROM users WHERE email LIKE ? ";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setPassword(rs.getString("password"));
                return user.getPassword();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void changePassword(int id, String password) {
        String sql = "UPDATE users SET password = ? WHERE id = ? ";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

