package com.fit.nlu.DHHCeramic.model;

import java.io.Serializable;
import java.util.Date;

public class Blog extends BaseModel implements Serializable {
    private String image;
    private String blogCate;
    private Date date;
    private String title;
    private String des;

    public Blog(String image, String blogCate, Date date, String title, String des) {
        this.image = image;
        this.blogCate = blogCate;
        this.date = date;
        this.title = title;
        this.des = des; // noi dung blog
    }

    public Blog() {
        super();
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBlogCate() {
        return blogCate;
    }

    public void setBlogCate(String blogCate) {
        this.blogCate = blogCate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "image='" + image + '\'' +
                ", blogCate='" + blogCate + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
