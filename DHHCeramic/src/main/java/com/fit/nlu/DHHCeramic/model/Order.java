package com.fit.nlu.DHHCeramic.model;


import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
    private String id;
    private User buyer;
    private Date buyDate;
    private String address;
    private String phoneNumber;
    private String note;
    private  Long total;
    private String status;
    public Order() {
        super();
    }

    public Order(String id, User buyer, Date buyDate, String address, String phoneNumber, String note, Long total, String status) {
        this.id = id;
        this.buyer = buyer;
        this.buyDate = buyDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.total = total;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", buyer=" + buyer +
                ", buyDate=" + buyDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", note='" + note + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                '}';
    }
}
