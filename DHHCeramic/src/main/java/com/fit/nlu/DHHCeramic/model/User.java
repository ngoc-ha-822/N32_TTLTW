package com.fit.nlu.DHHCeramic.model;

import java.io.Serializable;
import java.util.Date;

public class User extends BaseModel implements Serializable {
    private String email;
    private String fullname;
    private String facebook;
    private String username;
    private String password;
    private String avatar;
    private String address;
    private String phoneNumber;
    private Date birthday;
    private String code;
    private int status;
    private int roleId;

    public User() {
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String email, String username, String code, String password) {
        this.email = email;
        this.username = username;
        this.code = code;
        this.password = password;

    }

    public User(String email, String fullname, String facebook, String username, String password, String avatar, String address, String phoneNumber, Date birthday, int status, int roleId) {
        this.email = email;
        this.fullname = fullname;
        this.facebook = facebook;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.status = status;
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
