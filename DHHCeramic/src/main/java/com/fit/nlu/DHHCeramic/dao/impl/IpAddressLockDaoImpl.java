package com.fit.nlu.DHHCeramic.dao.impl;

import com.fit.nlu.DHHCeramic.dao.IpAddressLockDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IpAddressLockDaoImpl implements IpAddressLockDao {

    public void lockIpAddress(String ip, String reason) {
        String sql = "INSERT INTO lockIps (ip, reasonLock) VALUES (?, ?)";
        Connection con = JDBCConnection.getJDBCConnection();
        try (PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, ip);
            pre.setString(2, reason);

            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
