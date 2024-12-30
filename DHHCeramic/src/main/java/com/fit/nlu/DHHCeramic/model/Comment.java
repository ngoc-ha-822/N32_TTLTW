package com.fit.nlu.DHHCeramic.model;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable {
    private int id;
    private Product productId;
    private User username;
    private String avatar;
    private int rating;
    private String content;
    private Date time;

    public Comment() {
    }

    public Comment(Product productId, User username, int rating, String content) {
        this.productId = productId;
        this.username = username;
        this.rating = rating;
        this.content = content;
    }

    public Comment(int id, Product productId, User username, String avatar, int rating, String content, Date time) {
        this.id = id;
        this.productId = productId;
        this.username = username;
        this.avatar = avatar;
        this.rating = rating;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct_id() {
        return productId;
    }

    public void setProduct_id(Product product_id) {
        this.productId = product_id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", productId=" + productId +
                ", username=" + username +
                ", avatar='" + avatar + '\'' +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
