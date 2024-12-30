package com.fit.nlu.DHHCeramic.model;

import java.io.Serializable;

public class Product extends BaseModel implements Serializable {
    private int id;
    private String name;
    private long price;
    private long saleId;
    private Category category;
    private int stock;
    private String des;
    private String image;
    private int isLike;
    private int status;
    private String size;
    private String manufacture;

    private int remainingStock;
    private String stockStatus;

    public Product() {
        super();
    }

    public Product(int id, String name, long price, long saleId, Category category, int stock, String des, String image, int isLike, int status, String size, String manufacture, int remainingStock, String stockStatus) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.saleId = saleId;
        this.category = category;
        this.stock = stock;
        this.des = des;
        this.image = image;
        this.isLike = isLike;
        this.status = status;
        this.size = size;
        this.manufacture = manufacture;
        this.remainingStock = remainingStock;
        this.stockStatus = stockStatus;
    }

    @Override
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsLiked() {
        return isLike;
    }

    public void setIsLiked(int isLiked) {
        this.isLike = isLike;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", saleId=" + saleId +
                ", category=" + category +
                ", stock=" + stock +
                ", des='" + des + '\'' +
                ", image='" + image + '\'' +
                ", isLike=" + isLike +
                ", status=" + status +
                ", size='" + size + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", remainingStock=" + remainingStock +
                ", stockStatus='" + stockStatus + '\'' +
                '}';
    }
}