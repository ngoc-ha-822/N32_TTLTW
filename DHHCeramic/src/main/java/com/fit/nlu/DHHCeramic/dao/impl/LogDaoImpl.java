package com.fit.nlu.DHHCeramic.dao.impl;

import com.fit.nlu.DHHCeramic.dao.LogDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogDaoImpl implements LogDao {
    @Override
    public void insert(Log log) {
        String sql = "INSERT INTO logs (ip, level, address, prevalue, value,createdAt, createdDate) VALUES (?,?,?, ?, ?, ?, ?)";
        Connection con = JDBCConnection.getJDBCConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, log.getIp());
            statement.setInt(2, log.getLevel());
            statement.setString(3, log.getAddress());
            statement.setString(4, log.getPrevalue());
            statement.setString(5, log.getValue());
            statement.setString(6, log.getCreatedBy());
            // Chuyển đổi từ java.util.Date sang java.sql.Date
            statement.setDate(7, new java.sql.Date(log.getCreatedDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Log log) {
        String sql = "UPDATE logs SET level = ? WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, log.getLevel());
            statement.setInt(2, log.getId()); // Assuming a field named 'id' exists for the primary key
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(int id) {
        String sql = "DELETE FROM logs WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Log> loadAllLog() {
        List<Log> logs = new ArrayList<>();
        String sql = "SELECT * FROM logs";
        Connection con = JDBCConnection.getJDBCConnection();
        try (PreparedStatement pre = con.prepareStatement(sql);
             ResultSet resultSet = pre.executeQuery(sql)) {
            while (resultSet.next()) {
                Log log = new Log();
                log.setId(resultSet.getInt("id"));
                log.setIp(resultSet.getString("ip"));
                log.setLevel(resultSet.getInt("level"));
                log.setAddress(resultSet.getString("address"));
                log.setPrevalue(resultSet.getString("prevalue"));
                log.setValue(resultSet.getString("value"));
                log.setCreatedBy(resultSet.getString("createdAt"));
                log.setCreatedDate(resultSet.getDate("createdDate"));
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }


    @Override
    public Log getLogById(int id) {
        Log log = null;
        String sql = "SELECT id, ip, level, address, prevalue, value FROM logs WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                log = new Log();
                log.setId(rs.getInt("id"));
                log.setIp(rs.getString("ip"));
                log.setLevel(rs.getInt("level"));
                log.setAddress(rs.getString("address"));
                log.setPrevalue(rs.getString("prevalue"));
                log.setValue(rs.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return log;
    }

    @Override
    public void checked(int id) {
        Connection con = JDBCConnection.getJDBCConnection();
        String query = "UPDATE logs SET status = 1 where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}