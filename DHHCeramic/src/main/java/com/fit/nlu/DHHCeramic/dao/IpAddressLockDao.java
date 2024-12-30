package com.fit.nlu.DHHCeramic.dao;

public interface IpAddressLockDao {
    void lockIpAddress(String ipAddress, String reason);
}
